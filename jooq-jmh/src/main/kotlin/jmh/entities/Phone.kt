package jmh.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(
    name = "phone",
    schema = "jooq-jmh",
)
data class Phone(
    @Id
    @Column(name = "id", nullable = false)
    private var id: String? = null,

    @Column(name = "number", nullable = false)
    private var number: String? = null,

    @Column(name = "created_at", updatable = false)
    val createdAt: LocalDateTime? = null,
)
