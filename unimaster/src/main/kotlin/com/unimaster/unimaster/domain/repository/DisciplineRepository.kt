package com.unimaster.unimaster.domain.repository

import com.unimaster.unimaster.domain.model.Discipline
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DisciplineRepository : JpaRepository<Discipline, Long> {
}