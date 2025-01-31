package jmh

import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options.OptionsBuilder
import kotlin.test.Test

abstract class AbstractBenchmark {
//    private final static Integer MEASUREMENT_ITERATIONS = 10;
//    private final static Integer WARMUP_ITERATIONS = 3;
//    @Value("${jmh.result.path}")
//    private String path;

    @Test
    fun executeJmhRunner() {
        /*Options opt = new OptionsBuilder()
            // set the class name regex for benchmarks to search for to the current class
            .include("\\." + this.getClass().getSimpleName() + "\\.")
            .warmupIterations(WARMUP_ITERATIONS)
            .measurementIterations(MEASUREMENT_ITERATIONS)
            .timeUnit(TimeUnit.MILLISECONDS)
            // do not use forking or the benchmark methods will not see references stored within its class
            .forks(0)
            // do not use multiple threads
            .threads(1)
            .shouldDoGC(true)
            .shouldFailOnError(true)
            .resultFormat(ResultFormatType.JSON)
            .result(path)
            //.result("src/main/resources/result.json") // set this to a valid filename if you want reports
            .shouldFailOnError(true)
            .jvmArgs("-server")
            .build();
*/
        Runner(OptionsBuilder().build()).run()

    }
}