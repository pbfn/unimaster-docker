package com.unimaster.unimaster.domain.repository

import com.unimaster.unimaster.domain.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.userID = :idUsuario")
    fun findByUserId(@Param("idUsuario") idUsuario: Long): Person?
}