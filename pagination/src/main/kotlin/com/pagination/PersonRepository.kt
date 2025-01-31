package com.pagination

import com.pagination.entities.Person
import jakarta.transaction.Transactional
import org.springframework.data.domain.ScrollPosition
import org.springframework.data.domain.Window
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
@Transactional
interface PersonRepository : JpaRepository<Person?, Long?> {
    fun findFirst100ByLastnameOrderByFirstname(
        lastname: String?,
        scrollPosition: ScrollPosition?
    ): Window<Person?>?
}
