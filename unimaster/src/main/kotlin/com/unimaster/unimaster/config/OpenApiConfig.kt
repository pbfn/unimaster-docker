package com.unimaster.unimaster.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration



@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenApi(): OpenAPI{
        return OpenAPI()
            .info(
                Info()
                    .title("RESTful Api With Kotlin")
                    .version("v1")
                    .description("Api para o sistema Unimaster")
            )
    }
}