package com.unimaster.unimaster.services

import com.unimaster.unimaster.domain.model.Person
import com.unimaster.unimaster.domain.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.util.logging.Logger

@Service
class PersonService {
    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll():List<Person>{
        logger.info("Find all persons!")
        return repository.findAll()
    }

    fun create(model: Person): Person {
        logger.info("Creating one person with login is ${model.personID}!")
        if (repository.existsById(model.personID)) {
            throw IllegalArgumentException("Ja existe uma pessoa com id ${model.personID}")
        }
        return repository.save(model)
    }

    fun update(model:Person): Person{
        logger.info("Creating one person with login is ${model.personID}!")
        if (!repository.existsById(model.personID)) {
            throw IllegalArgumentException("Não existe uma pessoa com id ${model.personID}")
        }
        return repository.save(model)
    }
}