package com.longjobs.entities

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime

@Entity
@Table(
    name = "job",
    schema = "long-jobs",
)
data class Job(
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false)
    val id: String? = null,

    @Column(name = "state", nullable = false)
    val state: Int = 0,

    @Column(name = "count", nullable = false)
    val count: Int = 0,

    @Column(name = "diff", nullable = false)
    val diff: Int = 1,

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    val createdAt: LocalDateTime? = null,
)
