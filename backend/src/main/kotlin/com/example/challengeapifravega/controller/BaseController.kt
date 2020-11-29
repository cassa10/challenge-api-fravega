package com.example.challengeapifravega.controller

import com.example.challengeapifravega.service.logger.LogExecution
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class BaseController(){

    @GetMapping
    @LogExecution
    fun testAPI() : String {
        return "API running"
    }
}