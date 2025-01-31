package tx.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(
    name = "person",
    schema = "kafka-tx",
)
open class Person(
    @Id
    @Column(name = "id", nullable = false)
    open var id: String? = null,

    @Column(name = "firstname", nullable = false)
    open var firstname: String? = null,

    @Column(name = "lastname", nullable = false)
    open var lastname: String? = null,

    @Column(name = "age", nullable = false)
    open var age: Int = 0,

    @Column(name = "created_at", updatable = false)
    open val createdAt: LocalDateTime? = null,
)
