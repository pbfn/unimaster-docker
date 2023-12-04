package com.unimaster.unimaster.services

import com.unimaster.unimaster.domain.model.Discipline
import com.unimaster.unimaster.domain.repository.DisciplineRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class DisciplineService {

    @Autowired
    private lateinit var repository: DisciplineRepository

    private val logger = Logger.getLogger(DisciplineService::class.java.name)

    fun getDisciplineById(idDiscipline: Long): String? {
        logger.info("Trying log discipline $idDiscipline")
        val discipline = repository.getReferenceById(idDiscipline)
        return discipline.nameDiscipline
    }
}