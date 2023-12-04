package com.unimaster.unimaster.domain.repository

import com.unimaster.unimaster.domain.model.Permission
import org.springframework.data.jpa.repository.JpaRepository

interface PermissionRepository: JpaRepository<Permission, Long?>