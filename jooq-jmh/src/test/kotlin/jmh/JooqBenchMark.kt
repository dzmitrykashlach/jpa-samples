package jmh

import org.openjdk.jmh.annotations.*
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest


@DataJpaTest(
    properties = arrayOf(
        "spring.datasource.url=jdbc:postgresql://localhost:5432/postgres?currentSchema=jooq-jmh",
        "spring.jpa.hibernate.ddl-auto=create-drop",
        "spring.datasource.username=postgres",
        "spring.datasource.password=root"
    )
)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@State(Scope.Benchmark)
class JooqBenchMark : AbstractBenchMark() {
    @Param("100000", "10000000")
    var power = 0


    @Benchmark
    fun pow2() {
        var result = 1
        for (i in 1..power) {
            result *= 2
        }
    }
}




