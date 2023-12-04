package com.unimaster.unimaster.controller

import com.unimaster.unimaster.services.PermissionService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Permissions Endpoint")
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RestController
@RequestMapping("/permissions")
class PermissionsController {

    @Autowired
    lateinit var permissionService: PermissionService

    @GetMapping
    @Operation(summary = "Get all types of permissions")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Sucesso")
        ]
    )
    fun getAllPermissions(): ResponseEntity<*> {
        return ResponseEntity.ok(permissionService.getAllPermissions())
    }
}