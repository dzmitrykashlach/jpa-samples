package com.longjobs

import com.longjobs.entities.Job
import com.longjobs.service.JobService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import java.util.concurrent.CompletableFuture


@SpringBootTest
@EnableJpaRepositories(
    basePackages = ["com.longjobs"],
)
@EntityScan("com.longjobs.entities")
@EnableAutoConfiguration
class LongJobsTest {

    @Autowired
    lateinit var jobService: JobService

    @Test
    fun createJobsTest() {
        val jobs = mutableListOf(
       /*     Job(count = 100, diff = 1),
            Job(count = 102, diff = 3),
            Job(count = 240, diff = 4),*/
            Job(count = 75, diff = 5)
        )
        val cfs = mutableListOf<CompletableFuture<Void>>()
        jobs.forEach {
            jobService.createJob(it)
                .also {
                    cfs.add(it)
                }
        }
        CompletableFuture.allOf(*cfs.toTypedArray()).join()
    }
}