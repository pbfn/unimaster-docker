package com.unimaster.unimaster.service.impl

import com.unimaster.unimaster.domain.model.Person
import com.unimaster.unimaster.domain.repository.PersonRepository
import com.unimaster.unimaster.service.PersonService
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.util.logging.Logger

@Service
class PersonServiceImpl(private val personRepository: PersonRepository) : PersonService {

    private val logger = Logger.getLogger(PersonServiceImpl::class.java.name)
    override fun findAll(): List<Person> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Person {
        TODO("Not yet implemented")
    }

    override fun create(model: Person): Person {
        logger.info("Creating one person with login is ${model.personID}!")
        if (personRepository.existsById(model.personID)) {
            throw IllegalArgumentException("Ja existe uma pessoa com id ${model.personID}")
        }
        return personRepository.save(model)
    }

    override fun update(id: Long, model: Person): Person {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}