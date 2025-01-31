package com.nplusone.n1.problem

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootTest
    (classes = arrayOf(TestConfig::class))
@EnableJpaRepositories(
    basePackages = ["com.nplusone.n1.problem"],
)
@EntityScan("com.nplusone.n1.problem.entities")
@EnableAutoConfiguration
class NPluOneIntegrationTest {

    @Autowired
    lateinit var userDetailsRepository: UserDetailsRepository

    @Test
    fun test() {
        userDetailsRepository
            .findByNameContaining("John")
            .stream()
            .forEach { u -> println(u.addresses?.stream()?.forEach { a -> println(a.city) }) }

    }
}