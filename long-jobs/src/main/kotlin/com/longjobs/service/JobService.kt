package com.longjobs.service

import com.longjobs.entities.Job
import org.springframework.context.event.ContextRefreshedEvent
import java.util.concurrent.CompletableFuture

interface JobService {

    fun createJob(job: Job): CompletableFuture<Void>
    fun resumeJobs(event: ContextRefreshedEvent)
}