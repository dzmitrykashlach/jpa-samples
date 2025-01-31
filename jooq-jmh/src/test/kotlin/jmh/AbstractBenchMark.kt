package jmh

import org.openjdk.jmh.results.format.ResultFormatType
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.RunnerException
import org.openjdk.jmh.runner.options.Options
import org.openjdk.jmh.runner.options.OptionsBuilder
import org.springframework.beans.factory.annotation.Value
import java.util.concurrent.TimeUnit
import kotlin.test.Test


abstract class AbstractBenchMark {


    @Value("\${jmh.result.path}")
    private val path: String? = null

    @Test
    @Throws(RunnerException::class)
    fun executeJmhRunner() {
        val opt: Options =
            OptionsBuilder() // set the class name regex for benchmarks to search for to the current class
                .include("\\." + this.javaClass.simpleName + "\\.")
                .warmupIterations(WARMUP_ITERATIONS)
                .measurementIterations(MEASUREMENT_ITERATIONS)
                .timeUnit(TimeUnit.MILLISECONDS) // do not use forking or the benchmark methods will not see references stored within its class
                .forks(0) // do not use multiple threads
                .threads(1)
                .shouldDoGC(true)
                .shouldFailOnError(true)
                .resultFormat(ResultFormatType.JSON)
                .result(path) //.result("src/main/resources/result.json") // set this to a valid filename if you want reports
                .shouldFailOnError(true)
                .jvmArgs("-server")
                .build()

        Runner(opt).run()
    }
    private companion object{
        private val MEASUREMENT_ITERATIONS: Int = 10
        private val WARMUP_ITERATIONS: Int = 3
    }
}