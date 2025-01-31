package tx

import com.gruelbox.transactionoutbox.Dialect
import com.gruelbox.transactionoutbox.Persistor
import com.gruelbox.transactionoutbox.TransactionManager
import com.gruelbox.transactionoutbox.TransactionOutbox
import com.gruelbox.transactionoutbox.jooq.JooqTransactionManager
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.jooq.impl.DataSourceConnectionProvider
import org.jooq.impl.DefaultConfiguration
import org.jooq.impl.ThreadLocalTransactionProvider
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import tx.entities.Application
import tx.entities.ApplicationStatus
import tx.entities.Person
import tx.service.ApplicationService
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.sql.DataSource


@SpringBootTest
@EnableAutoConfiguration
@Import(OutboxConfig::class)
class KafkaTxTest {
    @Autowired
    lateinit var applicationService: ApplicationService

    @Test
    fun sendApplicationTest() {
        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        applicationService.processApplication(
            Application(
                id = UUID.randomUUID().toString(),
                person = Person(
                    id = "d2edcb74-1148-4b0b-89ac-957a451d1a22",
                    firstname = "9fa034f4",
                    lastname = "1234567890",
                    age = 12,
                    createdAt = LocalDateTime.parse("2025-04-07 15:12:50.863", dateFormatter)
                ),
                status = ApplicationStatus.NEW,
                createdAt = LocalDateTime.now()
            )
        )
    }
}

@TestConfiguration
open class OutboxConfig {
    @Bean
    open fun transactionOutbox(
        outBoxTransactionManager: TransactionManager?,
        applicationContext: ApplicationContext?
    ): TransactionOutbox {
        return TransactionOutbox.builder()
            .transactionManager(JooqTransactionManager.create(dsl(), listener()))
            .persistor(Persistor.forDialect(Dialect.POSTGRESQL_9))
            .build()
    }

    @Bean
    open fun dataSource(): DataSource {
        val dataSourceBuilder = DataSourceBuilder.create()
        dataSourceBuilder.driverClassName("org.postgresql.Driver")
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/postgres?currentSchema=kafka-tx")
        dataSourceBuilder.username("postgres")
        dataSourceBuilder.password("root")
        return dataSourceBuilder.build()
    }

    @Bean
    open fun listener() = JooqTransactionManager.createListener()

    @Bean
    open fun dsl():DSLContext{
        val jooqConfig = DefaultConfiguration()
        val connectionProvider = DataSourceConnectionProvider(dataSource())
        jooqConfig.setConnectionProvider(connectionProvider)
        jooqConfig.setSQLDialect(SQLDialect.POSTGRES)
        jooqConfig.setTransactionProvider(ThreadLocalTransactionProvider(connectionProvider, true))
        jooqConfig.set(listener())
        return DSL.using(jooqConfig)

    }
}