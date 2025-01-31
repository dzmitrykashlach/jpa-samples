package com.nplusone.n1.problem.entities

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime


@Entity
@Table(name = "user_details")
data class UserDetails (
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = null,

    @Column(name = "name")
    val name: String? = null,

    @Column(name = "email")
    val email: String? = null,

    @Column(name = "mobile_number")
    val mobileNumber: String? = null,

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    val createdAt: LocalDateTime? = null,

    @Column(name = "updated_at", insertable = false)
    @UpdateTimestamp
    val updatedAt: LocalDateTime? = null,

    @OneToMany(cascade =  arrayOf(CascadeType.ALL), mappedBy = "userDetails", fetch = FetchType.EAGER)
    val addresses: List<Address>? = null
)