package com.transactions

import com.transactions.services.CommandService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootTest(classes = [Application::class])
@EnableJpaRepositories(
    basePackages = ["com.transactions"],
)
@EntityScan("com.transactions.entities")
@EnableAutoConfiguration
class CommandTest {

    @Autowired
    lateinit var commandService: CommandService

    @Test
    fun serviceTest() {
        commandService.processCommand(false,"process")
    }
}