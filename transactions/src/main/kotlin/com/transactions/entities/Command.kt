package com.transactions.entities

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "command")
data class Command(
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = null,

    @Column(name = "is_id_valid")
    val isIdValid: Boolean = false,

    @Column(name = "action")
    val action: String? = null,

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    val createdAt: LocalDateTime? = null,

    @Column(name = "updated_at", insertable = false)
    @UpdateTimestamp
    val updatedAt: LocalDateTime? = null,
)
