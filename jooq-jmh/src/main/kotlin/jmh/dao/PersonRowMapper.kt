package jmh.dao

import jmh.entities.Person
import jmh.jooq.generated.jooq_jmh.tables.Person.PERSON
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import org.jooq.Record
import org.jooq.Result
import java.time.LocalDateTime


class PersonRowMapper : RowMapper<Person> {

    override fun mapRow(rs: ResultSet, rowNum: Int): Person {
        val person = Person(
            id = rs.getString("id"),
            firstname = rs.getString("first_name"),
            lastname = rs.getString("last_name"),
            age = rs.getInt("age"),
            createdAt = LocalDateTime.parse(rs.getString("created_at"))
        )
        return person
    }

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
        val persons: MutableList<Person> = ArrayList<Person>()
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