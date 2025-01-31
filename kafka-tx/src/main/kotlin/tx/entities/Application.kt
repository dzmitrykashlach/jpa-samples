package tx.entities

import java.time.LocalDateTime

open class Application(
    open var id: String? = null,
    open var person: Person? = null,
    open var status: ApplicationStatus? = null,
    open val createdAt: LocalDateTime? = null,
)


