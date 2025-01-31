package com.pagination.entities

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime

@Entity
@Table(
    name = "person",
    schema = "pagination",
    indexes = [
        Index(name = "idx_person_firstname", columnList = "firstname"),
        Index(name = "idx_person_lastname", columnList = "lastname")
    ]
)
data class Person(
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false)
    private var id: String? = null,

    @Column(name = "firstname", nullable = false)
    private var firstname: String? = null,

    @Column(name = "lastname", nullable = false)
    private var lastname: String? = null,

    @Column(name = "age", nullable = false)
    private var age: Int = 0,

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    val createdAt: LocalDateTime? = null,

)
