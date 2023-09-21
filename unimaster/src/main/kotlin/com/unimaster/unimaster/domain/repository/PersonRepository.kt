package com.unimaster.unimaster.domain.repository

import com.unimaster.unimaster.domain.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long?>