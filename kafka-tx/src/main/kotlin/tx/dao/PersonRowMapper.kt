package tx.dao

import tx.entities.Person
import kafka.tx.jooq.generated.kafka_tx.tables.Person.PERSON
import org.jooq.Record
import org.jooq.Result
import java.time.LocalDateTime


class PersonRowMapper {

    fun mapPersonRecord(record: Record): Person {
        return Person(
            id = record.get(PERSON.ID),
            firstname =record.get(PERSON.FIRST_NAME),
            lastname = record.get(PERSON.LAST_NAME),
            age = record.get(PERSON.AGE),
            createdAt = LocalDateTime.from(record.get(PERSON.CREATED_AT))
        )
    }

    fun <R : Record?> mapPersonRecords(records: Result<R>): List<Person> {
        val persons: MutableList<Person> = ArrayList()
        for (record in records) {
            if (record != null) {
                persons.add(
                    Person(
                        id = record.get(PERSON.ID),
                        firstname =record.get(PERSON.FIRST_NAME),
                        lastname = record.get(PERSON.LAST_NAME),
                        age = record.get(PERSON.AGE),
                        createdAt = LocalDateTime.from(record.get(PERSON.CREATED_AT))
                    )
                )
            }
        }
        return persons
    }
}