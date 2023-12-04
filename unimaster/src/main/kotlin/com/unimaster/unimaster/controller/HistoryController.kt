package com.unimaster.unimaster.controller

import com.unimaster.unimaster.controller.dto.HistoryDTO
import com.unimaster.unimaster.controller.dto.ListHistoryDTO
import com.unimaster.unimaster.controller.dto.toDTO
import com.unimaster.unimaster.services.DisciplineService
import com.unimaster.unimaster.services.HistoryStudentService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "History Endpoint")
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RestController
@RequestMapping("/history")
class HistoryController {

    @Autowired
    lateinit var service: HistoryStudentService

    @Autowired
    lateinit var disciplineService: DisciplineService


    @GetMapping("{idStudent}")
    fun getHistory(@PathVariable("idStudent") idStudent: String): ResponseEntity<List<HistoryDTO>> {

        val listHistoryLocal = service.getHistoryByUser(idStudent)
        val historyDTO = mutableListOf<HistoryDTO>()


        if (!listHistoryLocal.isNullOrEmpty()) {
            for (historyLocal in listHistoryLocal) {
                val disciplineName = disciplineService.getDisciplineById(historyLocal.disciplineId)
                val aux = historyLocal.toDTO(disciplineName = disciplineName!!)
                historyDTO.add(aux)
            }
        }
        return ResponseEntity.ok(historyDTO)
    }
}