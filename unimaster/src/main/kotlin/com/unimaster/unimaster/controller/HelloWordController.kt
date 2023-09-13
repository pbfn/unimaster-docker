package com.unimaster.unimaster.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloWordController {

    @GetMapping
    @Operation(summary = "Teste de hello World", description = "Este é um enpoint de teste")
    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "Operation successfull")])
    fun hello():String{
        return "Hello World"
    }
}