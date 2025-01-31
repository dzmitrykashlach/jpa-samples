package tx

import com.gruelbox.transactionoutbox.Dialect
import com.gruelbox.transactionoutbox.Persistor
import com.gruelbox.transactionoutbox.TransactionManager
import com.gruelbox.transactionoutbox.TransactionOutbox
import com.gruelbox.transactionoutbox.spring.SpringInstantiator
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
import java.util.UUID
import javax.sql.DataSource


@SpringBootTest
@EnableAutoConfiguration
@Import(OutboxConfig::class)
class KafkaTxTest {
    @Autowired
    lateinit var applicationService: ApplicationService

    @Test
    fun sendApplicationTest() {
        applicationService.processApplication(Application(
            id = UUID.randomUUID().toString(),
            person = Person(
                id =  UUID.randomUUID().toString(),
                firstname = ";asldkfj",
                lastname = ";alsdkfja;",
                age = 45,
                createdAt = LocalDateTime.now()
            ),
            status = ApplicationStatus.NEW,
            createdAt = LocalDateTime.now()
        ))
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
            .instantiator(SpringInstantiator(applicationContext))
            .transactionManager(outBoxTransactionManager)
            .persistor(Persistor.forDialect(Dialect.POSTGRESQL_9))
            .build()
    }

    @Bean
    open fun outBoxTransactionManager(dataSource: DataSource): TransactionManager {
        return TransactionManager.fromDataSource(dataSource)
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
}