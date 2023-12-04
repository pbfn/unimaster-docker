package com.unimaster.unimaster.domain.model

import jakarta.persistence.*

@Entity
@Table(name = "test_discipline")
data class TestDiscipline(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "id_discipline", nullable = false)
    val disciplineId: Long,

    @Column(name = "id_student", nullable = false)
    val studentId: Long,

    @Column(name = "description")
    val description: String? = null,

    @Column(name = "total_value")
    val totalValue: Double? = null,

    @Column(name = "value_achieved")
    val valueAchieved: Double? = null,
)