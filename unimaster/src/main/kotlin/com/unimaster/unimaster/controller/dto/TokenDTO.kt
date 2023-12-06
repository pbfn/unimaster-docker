package com.unimaster.unimaster.controller.dto

import java.util.*

data class TokenDTO(
    val username: String? = null,
    val authenticated: Boolean? = null,
    val created: Date? = null,
    val expiration: Date? = null,
    val accessToken: String? = null,
    val refreshToken: String? = null,
    var idUser: Long? = 0,
    var idPessoa: Long? = 0
)
