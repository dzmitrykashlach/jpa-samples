package com.longjobs.repository

import com.longjobs.entities.Job
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
@Transactional
interface JobRepository : JpaRepository<Job?, Long?> {
    @Query(
        value = "SELECT * FROM JOB j WHERE j.state < j.count",
        nativeQuery = true)
    fun findUnfinishedJobs():List<Job>
}
