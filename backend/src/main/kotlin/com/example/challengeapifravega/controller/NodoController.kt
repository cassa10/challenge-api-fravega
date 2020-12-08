package com.example.challengeapifravega.controller

import com.example.challengeapifravega.controller.dto.NodoDTO
import com.example.challengeapifravega.controller.dto.UbicacionDTO
import com.example.challengeapifravega.service.NodoService
import com.example.challengeapifravega.service.logger.LogExecution
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/nodo")
@Validated
class NodoController(@Autowired val nodoService: NodoService) {

    @GetMapping
    @LogExecution
    fun getNodes(): Collection<NodoDTO> {
        return nodoService.getAll().map { NodoDTO.Builder(it).build() }
    }

    @GetMapping("/cercano")
    @LogExecution
    fun getNearNode(@Valid ubicacionDTO: UbicacionDTO): NodoDTO {
        val nodoCercano = nodoService.getNodoCercano(ubicacionDTO.mapToUbicacion())
        return NodoDTO.Builder(nodoCercano).build()
    }
}