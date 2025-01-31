package tx.dao

import tx.entities.Person
import kafka.tx.jooq.generated.kafka_tx.tables.Application.APPLICATION
import org.jooq.Record
import org.jooq.Result
import tx.entities.Application
import tx.entities.ApplicationStatus
import java.time.LocalDateTime


class ApplicationRowMapper {

    fun mapApplicationRecord(record: Record): Application {
        return Application(
            id = record.get(APPLICATION.ID),
            person = Person(
                id = record.get(APPLICATION.person().ID),
                firstname = record.get(APPLICATION.person().FIRST_NAME),
                lastname = record.get(APPLICATION.person().LAST_NAME),
                age = record.get(APPLICATION.person().AGE),
                createdAt = record.get(APPLICATION.person().CREATED_AT),
            ),
            status = ApplicationStatus.get(record.get(APPLICATION.STATUS)),
            createdAt = LocalDateTime.from(record.get(APPLICATION.CREATED_AT))
        )
    }

    fun <R : Record?> mapApplicationRecords(records: Result<R>): List<Application> {
        val applications: MutableList<Application> = ArrayList()
        for (record in records) {
            if (record != null) {
                applications.add(
                    Application(
                        id = record.get(APPLICATION.ID),
                        person = Person(
                            id = record.get(APPLICATION.person().ID),
                            firstname = record.get(APPLICATION.person().FIRST_NAME),
                            lastname = record.get(APPLICATION.person().LAST_NAME),
                            age = record.get(APPLICATION.person().AGE),
                            createdAt = record.get(APPLICATION.person().CREATED_AT),
                        ),
                        status = ApplicationStatus.get(record.get(APPLICATION.STATUS)),
                        createdAt = LocalDateTime.from(record.get(APPLICATION.CREATED_AT))
                    )
                )
            }
        }
        return applications
    }
}