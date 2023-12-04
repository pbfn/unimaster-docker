package com.unimaster.unimaster.controller.dto

import com.unimaster.unimaster.domain.model.TestDiscipline


data class HistoryDTO(
    val id: Long,
    val idStudent: Long,
    val disciplineID: Long,
    val disciplineName: String,
    val description: String?,
    val valueAchieved: Double?,
    val valueTotal: Double?,
)

data class ListHistoryDTO(
    val data: List<HistoryDTO>,
    val distributedPoints: Double = 0.0,
    val totalPoints: Double = 0.0
)


fun TestDiscipline.toDTO(disciplineName: String): HistoryDTO = HistoryDTO(
    id = this.id,
    disciplineID = this.disciplineId,
    idStudent = this.studentId,
    description = this.description,
    valueAchieved = this.valueAchieved,
    valueTotal = this.totalValue,
    disciplineName = disciplineName
)