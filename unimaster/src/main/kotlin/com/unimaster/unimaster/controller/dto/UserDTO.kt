package com.unimaster.unimaster.controller.dto

import com.unimaster.unimaster.domain.model.User

data class UserDTO(
    val id: Long,
    val login: String,
    val profile: String
){
    constructor(model: User): this(
        id = model.userId,
        login = model.login,
        profile = model.profile
    )
}
