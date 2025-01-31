package com.transactions

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.ApplicationEventMulticaster
import org.springframework.context.event.SimpleApplicationEventMulticaster
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor


@Configuration
class EventBusConfiguration {
    // You can assign thread number for event multicaster
    @Bean(name = ["applicationEventMulticaster"])
    fun applicationEventMulticaster(): ApplicationEventMulticaster {
        val eventMulticaster = SimpleApplicationEventMulticaster()
        val threadPoolTaskExecutor = ThreadPoolTaskExecutor()
        threadPoolTaskExecutor.corePoolSize = 8
        threadPoolTaskExecutor.maxPoolSize = 16
        threadPoolTaskExecutor.initialize()
        eventMulticaster.setTaskExecutor(threadPoolTaskExecutor)
        return eventMulticaster
    }
}