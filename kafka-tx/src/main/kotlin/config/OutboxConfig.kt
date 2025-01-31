package config

import com.gruelbox.transactionoutbox.Persistor
import com.gruelbox.transactionoutbox.TransactionOutbox
import com.gruelbox.transactionoutbox.spring.SpringInstantiator
import com.gruelbox.transactionoutbox.spring.SpringTransactionManager
import com.gruelbox.transactionoutbox.Dialect
import org.springframework.context.annotation.Bean



class OutboxConfig {
    @Bean
    fun transactionOutbox(
        springTransactionManager: SpringTransactionManager?,
        springInstantiator: SpringInstantiator?
    ): TransactionOutbox {
        return TransactionOutbox.builder()
            .instantiator(springInstantiator)
            .transactionManager(springTransactionManager)
            .persistor(Persistor.forDialect(Dialect.POSTGRESQL_9))
            .build()
    }
}