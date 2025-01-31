package com.nplusone.n1.problem

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class TestConfig {

    @Bean
    fun jsonUtils(): JsonUtils {
        return JsonUtils()
    }
}