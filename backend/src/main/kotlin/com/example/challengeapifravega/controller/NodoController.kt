package com.example.challengeapifravega.controller

import com.example.challengeapifravega.service.logger.LogExecution
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/nodo")
@Validated
class NodoController {

    @GetMapping
    @LogExecution
    fun getNodes():String{
        return "Nodes"
    }
}