package com.example.challengeapifravega.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class Configuracion {

    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
            .pathMapping("/")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.example.challengeapifravega.controller"))
            .paths(PathSelectors.any())
            .build()
}