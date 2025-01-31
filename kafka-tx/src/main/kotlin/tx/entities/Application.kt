package tx.entities

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.LocalDateTime

@Entity
@Table(
    name = "application",
    schema = "kafka-tx",
)
open class Application(
    @Id
    @Column(name = "id", nullable = false)
    open var id: String? = null,

    @Column(name = "person", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    open var person: Person? = null,

    @Column(name = "status", nullable = false)
    open var status: ApplicationStatus? = null,

    @Column(name = "created_at", updatable = false)
    open val createdAt: LocalDateTime? = null,
)


