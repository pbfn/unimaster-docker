package com.unimaster.unimaster.controller.dto

import com.unimaster.unimaster.domain.model.Permission

data class AccountCredentialsSignupDTO(
    val username: String? = null,
    val password: String? = null,
    val permission: PermissionSignupDTO? = null
)

data class PermissionSignupDTO(
    val id: Long = 0
)