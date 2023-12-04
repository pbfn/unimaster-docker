package com.unimaster.unimaster.domain.repository

import com.unimaster.unimaster.domain.model.TestDiscipline
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
@Repository
interface HistoryRepository : JpaRepository<TestDiscipline, Long> {

    @Query("SELECT t FROM TestDiscipline t WHERE t.studentId = :studentId")
    fun findByStudentId(@Param("studentId") studentId: Long): List<TestDiscipline>
}