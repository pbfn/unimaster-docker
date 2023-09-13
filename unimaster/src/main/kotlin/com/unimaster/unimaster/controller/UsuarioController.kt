package com.unimaster.unimaster.controller

import com.unimaster.unimaster.controller.dto.AuthenticationDTO
import com.unimaster.unimaster.controller.dto.UsuarioDTO
import com.unimaster.unimaster.service.UsuarioService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticacao", description = "Fluxo de autenticação do usuário")
class UsuarioController(private val usuarioService: UsuarioService) {

    @CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
    @GetMapping
    @Operation(summary = "Get all users", description = "Retorna a lista com todos os usuarios")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Sucesso")
        ]
    )
    fun findAll(): ResponseEntity<List<UsuarioDTO>> {
        val usuarios = usuarioService.findAll()
        val usuariosDTO = usuarios.map { UsuarioDTO(it) }
        return ResponseEntity.ok(usuariosDTO)
    }

    @CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
    @PostMapping
    @Operation(summary = "Login", description = "Endpoint de login do usuario, caso de sucesso retorna um token")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Sucesso")
        ]
    )
    fun login(@RequestBody data: AuthenticationDTO): ResponseEntity<String> {


        return ResponseEntity.ok("Ok")
    }
}