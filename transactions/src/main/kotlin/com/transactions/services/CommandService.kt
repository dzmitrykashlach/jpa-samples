package com.transactions.services

import com.transactions.CommandEvent
import com.transactions.entities.Command
import com.transactions.repositories.CommandRepository
import org.springframework.context.event.ApplicationEventMulticaster
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class CommandService(
    val commandRepository: CommandRepository,
    val applicationEventMulticaster: ApplicationEventMulticaster
) {

    fun processCommand(isIdValid: Boolean, action: String) {
        println("=============================== thread before saving command => " + Thread.currentThread().name)
        commandRepository.save(Command(isIdValid = isIdValid, action = action))
            .let { applicationEventMulticaster.multicastEvent(CommandEvent(it)) }
    }

    @EventListener(classes = [CommandEvent::class])
    fun validatePerson() {
        println("=============================== listening thread => " + Thread.currentThread().name)
    }
}