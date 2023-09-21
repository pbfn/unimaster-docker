package com.unimaster.unimaster.controller

import com.unimaster.unimaster.controller.dto.AuthenticationDTO
import com.unimaster.unimaster.controller.dto.RegisterUserDTO
import com.unimaster.unimaster.controller.dto.UserDTO
import com.unimaster.unimaster.domain.model.Person
import com.unimaster.unimaster.domain.model.User
import com.unimaster.unimaster.service.PersonService
import com.unimaster.unimaster.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import lombok.extern.java.Log
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RestController
@RequestMapping("/user")
@Tag(name = "Usuários", description = "CRUD de usuários")
class UserController(private val userService: UserService, private val personService: PersonService) {

    @CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    @Operation(summary = "Get all users", description = "Retorna a lista com todos os usuarios")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Sucesso")
        ]
    )
    fun findAll(): ResponseEntity<List<UserDTO>> {
        val users = userService.findAll()
        val usersDTO = users.map { UserDTO(it) }
        return ResponseEntity.ok(usersDTO)
    }

    @GetMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Operation(summary = "Get user by id", description = "Retorna a lista com o usuário de acordo com o ID informado")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Sucesso")
        ]
    )
    fun findById(@PathVariable(value = "id") id: Long): ResponseEntity<UserDTO> {
        val user = userService.findById(id)
        val userDTO = UserDTO(user)

        return ResponseEntity.ok(userDTO)
    }

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
    fun create(@RequestBody registerUser: RegisterUserDTO): ResponseEntity<UserDTO> {
        val user = User(
            login = registerUser.login,
            password = registerUser.senha,
            profile = registerUser.perfil
        )
        val userDto = UserDTO(userService.create(user))
        val person = Person(
            user = user,
            cpf = registerUser.cpf,
            name = registerUser.nome,
            rg = registerUser.rg,
            telephone = registerUser.telefone,
            cep = registerUser.cep,
            address = registerUser.logradouro,
            number = registerUser.numero,
            neighborhood = registerUser.bairro,
            city = registerUser.cidade,
            state = registerUser.estado,
            fatherName = registerUser.nomePai,
            motherName = registerUser.nomeMae,
            salary = registerUser.salario
        )
        personService.create(person)
        return ResponseEntity.ok(userDto)
    }


    @PutMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Operation(summary = "Update user", description = "Altera um usuário")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Sucesso")
        ]
    )
    fun update(@RequestBody user: User): ResponseEntity<UserDTO> {
        return ResponseEntity.ok(UserDTO(userService.update(user.userId, user)))
    }

    @DeleteMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Operation(summary = "Delete user", description = "Deleta um usuário")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Sucesso")
        ]
    )
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<*> {
        userService.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }

//    @CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
//    @PostMapping
//    @Operation(summary = "Login", description = "Endpoint de login do usuario, caso de sucesso retorna um token")
//    @ApiResponses(
//        value = [
//            ApiResponse(responseCode = "200", description = "Sucesso")
//        ]
//    )
//    fun login(@RequestBody data: AuthenticationDTO): ResponseEntity<String> {
//
//
//        return ResponseEntity.ok("Ok")
//    }
}