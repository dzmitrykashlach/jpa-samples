package com.transactions.services

import com.transactions.entities.UserDetails
import com.transactions.repositories.UserDetailsRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class UserDetailsService(
    val userDetailsRepository: UserDetailsRepository,
    val applicationEventPublisher: ApplicationEventPublisher
) {

//    @Transactional
    fun createUserDetails(name: String, email: String, mobileNumber: String) {
        userDetailsRepository.save(UserDetails(name = name, email = email, mobileNumber = mobileNumber))
            .let { applicationEventPublisher.publishEvent(it) }
    }

    @EventListener(classes = [UserDetails::class])
//    @TransactionalEventListener(classes = [UserDetails::class], phase = TransactionPhase.BEFORE_COMMIT)
    fun eventListener() {
        println("===============================")
    }
}