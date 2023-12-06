package com.unimaster.unimaster.services

import com.unimaster.unimaster.domain.model.Permission
import com.unimaster.unimaster.domain.repository.PermissionRepository
import org.springframework.stereotype.Service
import java.util.logging.Logger


@Service
class PermissionService(private val permissionRepository: PermissionRepository) {

    private val logger = Logger.getLogger(PermissionService::class.java.name)
    fun getAllPermissions(): List<Permission> {
        logger.info("GetALl permissions")
        return permissionRepository.findAll()
    }
}