package com.example.challengeapifravega.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class BaseController(){

    @GetMapping
    fun testAPI() : String {
        return "API running"
    }
}