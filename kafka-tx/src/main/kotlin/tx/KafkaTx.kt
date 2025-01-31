package tx

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class JooqBenchMarkApplication

fun main(args: Array<String>) {
    runApplication<JooqBenchMarkApplication>(*args)
}