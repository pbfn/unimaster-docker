package com.unimaster.unimaster.domain.model

import jakarta.persistence.*

@Entity(name = "discipline")
@Table(name = "discipline")
data class Discipline(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var disciplineID: Long = 0,

    @Column(name = "name_discipline", nullable = true)
    var nameDiscipline: String?,

    @Column(name = "description_discipline", nullable = true)
    var descriptionDiscipline: String?,
)
