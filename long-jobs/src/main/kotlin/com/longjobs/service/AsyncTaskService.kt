package com.longjobs.service

import com.longjobs.entities.Job
import java.util.concurrent.CompletableFuture

interface AsyncTaskService {

    fun run(job: Job): CompletableFuture<Void>
}