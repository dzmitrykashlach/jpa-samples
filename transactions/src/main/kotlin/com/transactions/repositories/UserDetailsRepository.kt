package com.transactions.repositories

import com.transactions.entities.UserDetails
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
@Transactional(value = Transactional.TxType.SUPPORTS)
interface UserDetailsRepository : JpaRepository<UserDetails, String> {
    @EntityGraph(
        type = EntityGraph.EntityGraphType.FETCH,
        attributePaths = arrayOf("addresses")
    )
    fun findByNameContaining(text: String): List<UserDetails>
}