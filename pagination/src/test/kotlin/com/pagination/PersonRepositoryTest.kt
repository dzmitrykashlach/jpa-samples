package com.pagination

import com.pagination.entities.Person
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.KeysetScrollPosition
import org.springframework.data.domain.ScrollPosition
import org.springframework.data.domain.Window
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.support.WindowIterator


@SpringBootTest
@EnableJpaRepositories(
    basePackages = ["com.pagination"],
)
@EntityScan("com.pagination.entities")
@EnableAutoConfiguration
class PersonRepositoryTest {

    @Autowired
    lateinit var personRepository: PersonRepository

    @Test
    fun test() {
        val lastname = "1234567890"

        var start = System.currentTimeMillis()

        var offset: ScrollPosition = ScrollPosition.offset()
        var personWindow: Window<Person?>?
        do {
            personWindow = personRepository.findFirst100ByLastnameOrderByFirstname(lastname, offset)
            offset = personWindow!!.positionAt(personWindow.size() - 1)
        } while (personWindow!!.hasNext())

        var finish = System.currentTimeMillis() - start
        println("offsetTime => $finish")

        start = System.currentTimeMillis()

        var keyset = ScrollPosition.keyset()
        do {
            personWindow = personRepository.findFirst100ByLastnameOrderByFirstname(lastname, keyset)
            if (personWindow!!.hasNext()) {
                keyset = personWindow.positionAt(personWindow.size() - 1) as KeysetScrollPosition
            }
        } while (personWindow!!.hasNext())

        finish = System.currentTimeMillis() - start
        println("keysetTime => $finish")

        val persons: WindowIterator<Person> = WindowIterator.of<Person> { position: ScrollPosition? ->
            personRepository.findFirst100ByLastnameOrderByFirstname(
                "1234567890",
                position
            )
        }.startingAt(ScrollPosition.keyset())

        start = System.currentTimeMillis()
        while (persons.hasNext()) {
            persons.next().toString()
        }
        finish = System.currentTimeMillis() - start
        println("keysetTime with windowIterator => $finish")
    }
}