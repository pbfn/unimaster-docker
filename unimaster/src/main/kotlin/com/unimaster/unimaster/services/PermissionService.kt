package com.unimaster.unimaster.services

import com.unimaster.unimaster.domain.model.Permission
import com.unimaster.unimaster.domain.repository.PermissionRepository
import com.unimaster.unimaster.services.impl.PersonServiceImpl
import org.springframework.stereotype.Service
import java.util.logging.Logger


@Service
class PermissionService(private val permissionRepository: PermissionRepository) {

    private val logger = Logger.getLogger(PersonServiceImpl::class.java.name)
    fun getAllPermissions(): List<Permission> {
        logger.info("GetALl permissions")
        return permissionRepository.findAll()
    }
}