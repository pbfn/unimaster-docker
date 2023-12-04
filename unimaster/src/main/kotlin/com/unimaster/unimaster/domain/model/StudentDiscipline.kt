package com.unimaster.unimaster.domain.model

import jakarta.persistence.*

@Entity(name = "student_discipline")
@Table(name = "student_discipline")
data class StudentDiscipline(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val studentDisciplineId: Long = 0,

    @Column(name = "id_student", nullable = false)
    val studentId: Long,

    @Column(name = "id_teacher", nullable = false)
    val teacherId: Long,

    @Column(name = "id_discipline", nullable = false)
    val disciplineId: Long,

    @Column(name = "period")
    val period: String? = null,

    @Column(name = "status")
    val status: String? = null,

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id", insertable = false, updatable = false)
    val student: User? = null,

    @ManyToOne
    @JoinColumn(name = "id_teacher", referencedColumnName = "id", insertable = false, updatable = false)
    val teacher: User? = null,

    @ManyToOne
    @JoinColumn(name = "id_discipline", referencedColumnName = "id", insertable = false, updatable = false)
    val discipline: Discipline? = null
)