package com.unimaster.unimaster.controller

import com.unimaster.unimaster.controller.dto.PersonDTO
import com.unimaster.unimaster.domain.model.Person
import com.unimaster.unimaster.services.PersonService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RestController
@RequestMapping("/person")
@Tag(name = "Pessoa", description = "CRUD de pessoa")
class PersonController(private val personService: PersonService) {

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Operation(summary = "Create user", description = "Cria um usuário e uma pessoa")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Sucesso")
        ]
    )
    fun create(@RequestBody person: PersonDTO): ResponseEntity<PersonDTO> {

        val newPerson = Person(
            userID = person.userID.toLong(),
            cpf = person.cpf,
            name = person.nome,
            rg = person.rg,
            telephone = person.telefone,
            cep = person.cep,
            address = person.logradouro,
            number = person.numero,
            neighborhood = person.bairro,
            city = person.cidade,
            state = person.estado,
            fatherName = person.nomePai,
            motherName = person.nomeMae,
            salary = person.salario
        )
        personService.create(newPerson)
        return ResponseEntity.ok(person)
    }

    @GetMapping
    @Operation(summary = "Get all persons", description = "Get all persons")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Sucesso")
        ]
    )
    fun findAllPerson(): ResponseEntity<*> {
        return ResponseEntity.ok(personService.findAll())
    }
}