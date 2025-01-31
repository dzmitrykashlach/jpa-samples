package com.nplusone.n1.problem.entities


import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "address")
data class Address (
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private val id: String? = null,

    @Column(name = "address1")
    private val address1: String? = null,

    @Column(name = "address2")
    private val address2: String? = null,

    @Column(name = "street")
    val street: String? = null,

    @Column(name = "city")
    val city: String? = null,

    @Column(name = "state")
    val state: String? = null,

    @Column(name = "country")
    val country: String? = null,

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    val createdAt: LocalDateTime? = null,

    @Column(name = "updated_at", insertable = false)
    @UpdateTimestamp
    val updatedAt: LocalDateTime? = null,

    @ManyToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val userDetails: UserDetails? = null
)