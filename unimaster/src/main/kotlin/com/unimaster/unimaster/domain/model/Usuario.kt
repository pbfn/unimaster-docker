package com.unimaster.unimaster.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "usuario")
data class Usuario(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val idusuario: String,
    val login: String,
    val senha: String,
    val perfil: String,

    )
