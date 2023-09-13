package com.unimaster.unimaster.controller.dto

import com.unimaster.unimaster.domain.model.Usuario

data class UsuarioDTO(
    val id: String,
    val login: String,
    val perfil: String
){
    constructor(model: Usuario): this(
        id = model.idusuario,
        login = model.login,
        perfil = model.perfil
    )
}
