package com.transactions.repositories

import com.transactions.entities.Command
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommandRepository : JpaRepository<Command, String>