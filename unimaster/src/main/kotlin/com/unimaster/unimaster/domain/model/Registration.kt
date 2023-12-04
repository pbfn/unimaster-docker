package com.unimaster.unimaster.domain.model

import jakarta.persistence.*

@Entity(name = "registration")
@Table(name = "registration")
data class Registration(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val registrationId: Long = 0,

    @Column(name = "id_user", nullable = false)
    val userId: Long,

    @Column(name = "id_course", nullable = false)
    val courseId: Long,

    @Column(name = "year_of_entry")
    val yearOfEntry: String? = null,

    @Column(name = "status")
    val status: String? = null,

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", insertable = false, updatable = false)
    val user: User? = null,

    @ManyToOne
    @JoinColumn(name = "id_course", referencedColumnName = "id", insertable = false, updatable = false)
    val course: Course? = null
)
