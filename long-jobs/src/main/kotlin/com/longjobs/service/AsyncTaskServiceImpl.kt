package com.longjobs.service

import com.longjobs.entities.Job
import com.longjobs.repository.JobRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.task.AsyncTaskExecutor
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture


@Service
class AsyncTaskServiceImpl : AsyncTaskService {
    @Autowired
    lateinit var jobRepository: JobRepository

    @Autowired
    lateinit var asyncTaskExecutor:AsyncTaskExecutor

    override fun run(job: Job): CompletableFuture<Void> {
        var jobInProgress = job
        if (jobInProgress.count % jobInProgress.diff != 0) {
            return CompletableFuture.failedFuture(Exception(("count must be divisible by diff without a reminder")))
        }

    val cf = asyncTaskExecutor.submitCompletable{
        while (jobInProgress.state < job.count) {
            jobInProgress = jobInProgress.copy(
                state = jobInProgress.state.plus(1)
            )
            if (jobInProgress.state % jobInProgress.diff == 0) {
                jobInProgress = jobRepository.save(jobInProgress)
            }
            Thread.sleep(SLEEP)
        }
    }
        return cf
    }

    private companion object {
        const val SLEEP = 5000L
    }
}