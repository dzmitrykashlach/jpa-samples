package com.transactions

import com.transactions.repositories.UserDetailsRepository
import com.transactions.services.UserDetailsService
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
class TransactionalTest {

    @Autowired
    lateinit var userDetailsRepository: UserDetailsRepository

    @Autowired
    lateinit var userDetailsService: UserDetailsService

    @Test
    fun repositoryTest() {
        userDetailsRepository
            .findByNameContaining("John")
            .stream()
            .forEach { u -> println(u.addresses?.stream()?.forEach { a -> println(a.city) }) }
    }

    @Test
    fun serviceTest() {
        userDetailsService.createUserDetails("Johnkey","johnkey@gmail.com","+101928437109103")
    }


}