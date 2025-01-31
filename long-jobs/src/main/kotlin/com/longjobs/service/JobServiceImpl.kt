package com.longjobs.service

import com.longjobs.entities.Job
import com.longjobs.repository.JobRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture


@Service
class JobServiceImpl : JobService {

    @Autowired
    lateinit var jobRepository: JobRepository

    @Autowired
    lateinit var asyncTaskService: AsyncTaskService

    override fun createJob(job: Job):CompletableFuture<Void>{
            return asyncTaskService.run(job)
    }

    @EventListener(condition = "event.applicationContext.parent == null")
    override fun resumeJobs(event: ContextRefreshedEvent) {
        val jobs = jobRepository.findUnfinishedJobs()
        val cfs = mutableListOf<CompletableFuture<Void>>()
            for (j in jobs){
                cfs.add(asyncTaskService.run(j))
            }
        CompletableFuture.allOf(*cfs.toTypedArray())
    }


}