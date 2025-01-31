package tx.dao.impl

import kafka.tx.jooq.generated.kafka_tx.tables.Application.APPLICATION
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.Result
import org.springframework.stereotype.Repository
import tx.dao.ApplicationDao
import tx.dao.ApplicationRowMapper
import tx.entities.Application

@Repository
open class ApplicationDaoImpl(
    private var dslContext: DSLContext
) : ApplicationDao {

    override fun findAll(): List<Application?>? {
        val records: Result<Record> = dslContext
            .select().from(APPLICATION).fetch()
        return if (records.isEmpty())
            emptyList()
        else
            ApplicationRowMapper().mapApplicationRecords(records)
    }


    override fun findById(id: String?): Application? {
        val record = this.dslContext
            .select().from(APPLICATION).where(APPLICATION.PERSON_ID.eq(id))
            .fetchOne()
        return if (record == null)
            null
        else
            ApplicationRowMapper().mapApplicationRecord(record)
    }

    override fun save(application: Application?) {
        this.dslContext
            .insertInto(APPLICATION)
            .values(application!!.id,
                application.person!!.id,
                application.status,
                application.createdAt
            )
            .execute()
    }

    override fun delete(application: Application?) {
        if (application != null) {
            this.dslContext
                .delete(APPLICATION)
                .where(
                    APPLICATION.ID.eq(application.id)
                )
                .execute()
        }
    }
}