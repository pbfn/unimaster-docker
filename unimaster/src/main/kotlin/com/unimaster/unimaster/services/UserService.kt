package com.unimaster.unimaster.services

import com.unimaster.unimaster.domain.repository.UserRepository
import com.unimaster.unimaster.services.impl.PersonServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.logging.Logger
import kotlin.math.log

@Service
class UserService(@field:Autowired var repository: UserRepository) : UserDetailsService {

    private val logger = Logger.getLogger(UserService::class.java.name)
    override fun loadUserByUsername(username: String?): UserDetails {
        logger.info("Finding one User by Username $username")

        val user = repository.findByUsername(username)

        return user ?: throw  UsernameNotFoundException("Username $username not found")
    }


}