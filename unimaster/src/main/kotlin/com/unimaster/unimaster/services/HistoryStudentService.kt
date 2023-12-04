package com.unimaster.unimaster.services

import com.unimaster.unimaster.domain.model.TestDiscipline
import com.unimaster.unimaster.domain.repository.HistoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class HistoryStudentService {

    @Autowired
    private lateinit var repository: HistoryRepository

    private val logger = Logger.getLogger(HistoryStudentService::class.java.name)


    fun getHistoryByUser(idStudent: String): List<TestDiscipline>? {
        logger.info("Trying log history $idStudent")
        return repository.findByStudentId(idStudent.toLong())
    }
}