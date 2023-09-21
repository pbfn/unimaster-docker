package com.unimaster.unimaster.service.impl

import com.unimaster.unimaster.domain.model.User
import com.unimaster.unimaster.domain.repository.UserRepository
import com.unimaster.unimaster.exceptions.ResourceNotFoundException
import com.unimaster.unimaster.service.UserService
import jakarta.transaction.Transactional
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.util.logging.Logger

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    private val logger = Logger.getLogger(UserServiceImpl::class.java.name)

    override fun findAll(): List<User> {
        logger.info("Find All Users!")
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "idusuario"))
    }

    override fun findById(id: Long): User {
        logger.info("Find user by id!")
        return userRepository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
    }

    @Transactional
    override fun create(model: User): User {
        logger.info("Creating one user with login is ${model.login}!")
        if (userRepository.existsById(model.userId)) {
            throw IllegalArgumentException("Ja existe um usuario com id ${model.userId}")
        }
        return userRepository.save(model)
    }

    override fun update(id: Long, model: User): User {
        logger.info("Updating one user with id is ${id}!")
        val entity = userRepository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }

        entity.profile = model.profile
        entity.password = model.password

        return userRepository.save(entity)

    }

    override fun delete(id: Long) {
        logger.info("Deleting one user with id is ${id}!")
        val entity = userRepository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
        userRepository.delete(entity)
    }
}