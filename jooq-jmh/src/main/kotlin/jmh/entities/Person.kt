package jmh.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(
    name = "person",
    schema = "jooq-jmh",
)
data class Person(
    @Id
    @Column(name = "id", nullable = false)
    private var id: String? = null,

    @Column(name = "firstname", nullable = false)
    private var firstname: String? = null,

    @Column(name = "lastname", nullable = false)
    private var lastname: String? = null,

    @Column(name = "age", nullable = false)
    private var age: Int = 0,

    @Column(name = "created_at", updatable = false)
    val createdAt: LocalDateTime? = null,

)
