package com.nplusone.n1.problem

import com.nplusone.n1.problem.entities.UserDetails
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDetailsRepository : JpaRepository<UserDetails, String> {
    @EntityGraph(
        type = EntityGraph.EntityGraphType.FETCH,
        attributePaths = arrayOf("addresses")
    )
    fun findByNameContaining(text: String): List<UserDetails>
}