package com.unimaster.unimaster.services

import com.unimaster.unimaster.controller.dto.AccountCredentialsSignupDTO
import com.unimaster.unimaster.controller.dto.AccountCrendentialsDTO
import com.unimaster.unimaster.controller.dto.TokenDTO
import com.unimaster.unimaster.domain.model.User
import com.unimaster.unimaster.domain.repository.PersonRepository
import com.unimaster.unimaster.domain.repository.UserRepository
import com.unimaster.unimaster.security.jwt.JwtTokenProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class AuthService {

    @Autowired
    private lateinit var authenticationManager: AuthenticationManager

    @Autowired
    private lateinit var tokenProvider: JwtTokenProvider

    @Autowired
    private lateinit var repository: UserRepository

    @Autowired
    private lateinit var personRepository: PersonRepository


    private val logger = Logger.getLogger(AuthService::class.java.name)


    fun signin(data: AccountCrendentialsDTO): ResponseEntity<*> {
        logger.info("Trying log user ${data.username}")
        return try {
            val username = data.username
            val password = data.password
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(username, password))
            val user = repository.findByUsername(username)
            val tokenResponse: TokenDTO = if (user != null) {
                tokenProvider.createAccessToken(username!!, user.roles)
            } else {
                throw UsernameNotFoundException("Username $username not found!")
            }
            val person = personRepository.findByUserId(user.id)
            if (person != null) {
                tokenResponse.idPessoa = person.personID
            }
            tokenResponse.idUser = user.id
            ResponseEntity.ok(tokenResponse)
        } catch (e: AuthenticationException) {
            throw BadCredentialsException("Invalid username or password supplied")
        } catch (e: Exception) {
            throw BadCredentialsException("Invalid username or password supplied")
        }
    }

    fun signup(data: AccountCredentialsSignupDTO): ResponseEntity<*> {

        return try {
            val username = data.username
            val pbkdf2Encoder = Pbkdf2PasswordEncoder(
                "",
                8,
                185000,
                Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256
            )
            val encryptedPassword = pbkdf2Encoder.encode(data.password)
            val user = repository.findByUsername(username)
            if (user != null)
                throw BadCredentialsException("Exists a one user for by username equals $username")
            else {
                val newuser = User(
                    userName = data.username,
                    password = encryptedPassword,
                    fullName = "",
                    accountNonExpired = true,
                    accountNonLocked = true,
                    credentialsNonExpired = true,
                    enabled = true
                )
                repository.save(newuser)
                ResponseEntity.ok("User created")
            }

        } catch (e: AuthenticationException) {
            throw BadCredentialsException("Invalid username or password supplied")
        }

    }


    fun refreshToken(username: String, refreshToken: String): ResponseEntity<*> {
        logger.info("Trying refresh token user $username")

        val user = repository.findByUsername(username)
        val tokenResponse: TokenDTO = if (user != null) {
            tokenProvider.refreshToken(refreshToken)
        } else {
            throw UsernameNotFoundException("Username $username not found!")
        }
        return ResponseEntity.ok(tokenResponse)

    }
}