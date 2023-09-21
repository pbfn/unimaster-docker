package com.unimaster.unimaster.domain.model

import jakarta.persistence.*
import kotlin.math.log

@Entity(name = "usuario")
@Table(name = "usuario")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    var userId: Long = 0,

    @Column(name = "login", nullable = false, length = 50)
    var login: String,

    @Column(name = "senha", nullable = false, length = 80)
    var password: String,

    @Column(name = "perfil", nullable = false, length = 50)
    var profile: String
)
