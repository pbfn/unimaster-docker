package com.unimaster.unimaster.domain.model

import jakarta.persistence.*

@Entity(name = "course")
@Table(name = "course")
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var courseID: Long = 0,

    @Column(name = "name_course", nullable = true)
    var nameCourse: String?,

    @Column(name = "description_course", nullable = true)
    var descriptionCourse: String?,
)
