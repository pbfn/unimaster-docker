package com.unimaster.unimaster.controller

import com.unimaster.unimaster.controller.dto.AccountCredentialsSignupDTO
import com.unimaster.unimaster.controller.dto.AccountCrendentialsDTO
import com.unimaster.unimaster.services.AuthService
import com.unimaster.unimaster.services.PersonService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Authentication Endpoint")
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RestController
@RequestMapping("/auth")
class AuthController(private val personService: PersonService) {

    @Autowired
    lateinit var authService: AuthService

    @Operation(summary = "Authenticates an user and return a token")
    @PostMapping(value = ["/signin"])
    fun singin(@RequestBody data: AccountCrendentialsDTO?): ResponseEntity<*> {
        return if (data!!.username.isNullOrBlank() || data.password.isNullOrBlank())
            ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request")
        else authService.signin(data)
    }

    @Operation(summary = "Refresh token for authenticated user and returns a token")
    @PutMapping(value = ["/signin"])
    fun refreshToken(
        @PathVariable("username") username: String?,
        @RequestHeader("Authorization") refreshToken: String?
    ): ResponseEntity<*> {
        return if (refreshToken.isNullOrBlank() || username.isNullOrBlank())
            ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request")
        else authService.refreshToken(username, refreshToken)
    }

    @PostMapping(value = ["/signup"])
    fun singup(@RequestBody data: AccountCredentialsSignupDTO?): ResponseEntity<*> {

        if (data!!.username.isNullOrBlank() || data.password.isNullOrBlank())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request")
        else{
            authService.signup(data)
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Teste")
    }
}