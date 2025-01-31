package tx.dao.impl

import kafka.tx.jooq.generated.kafka_tx.tables.Application.APPLICATION
import tx.dao.PersonDao
import tx.dao.PersonRowMapper
import tx.entities.Person
import kafka.tx.jooq.generated.kafka_tx.tables.Person.PERSON
import kafka.tx.jooq.generated.kafka_tx.tables.records.ApplicationRecord
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.Result
import org.springframework.stereotype.Repository

@Repository
open class PersonDaoImpl : PersonDao {
    lateinit var dslContext: DSLContext

    override fun findAll(): List<Person?>? {
        val records: Result<Record> = dslContext
            .select().from(PERSON).fetch()
        return if (records.isEmpty())
            emptyList()
        else
            PersonRowMapper().mapPersonRecords(records)
    }


    override fun findById(id: String?): Person? {
        val record = this.dslContext
            .select().from(PERSON).where(PERSON.ID.eq(id))
            .fetchOne()
        return if (record == null)
            null
        else
            PersonRowMapper().mapPersonRecord(record)
    }

    override fun save(person: Person?) {
        this.dslContext
            .insertInto(PERSON)
            .values(
                ApplicationRecord()
                    .from(person)
            )
            .execute()
    }

    override fun delete(person: Person?) {
        if (person != null) {
            this.dslContext
                .delete(APPLICATION)
                .where(
                    APPLICATION.ID.eq(person.id)
                )
                .execute()
        }
    }
}