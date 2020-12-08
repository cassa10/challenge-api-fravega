package com.example.challengeapifravega.controller

import com.example.challengeapifravega.controller.dto.PuntoDeRetiroDTO
import com.example.challengeapifravega.exception.PuntoDeRetiroNoExiste
import com.example.challengeapifravega.model.PuntoDeRetiro
import com.example.challengeapifravega.service.PuntoDeRetiroService
import com.example.challengeapifravega.service.logger.LogExecution
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/puntoDeRetiro")
@Validated
class PuntoDeRetiroController(@Autowired val puntoDeRetiroService: PuntoDeRetiroService){

    @GetMapping
    @LogExecution
    fun getAllPuntoDeRetiro(): List<PuntoDeRetiroDTO> {
        return puntoDeRetiroService.getAll().map { PuntoDeRetiroDTO.Builder(it).build() }
    }


    @GetMapping("/{id}")
    @Throws(PuntoDeRetiroNoExiste::class)
    @LogExecution
    fun getPuntoDeRetiro(@PathVariable("id") @Valid idPuntoDeRetiro: Long): PuntoDeRetiroDTO{
        val maybePuntoDeRetiro = puntoDeRetiroService.get(idPuntoDeRetiro)
        return PuntoDeRetiroDTO.Builder(puntoDeRetiroService.validateIfExistAndReturn(maybePuntoDeRetiro)).build()
    }

    @PostMapping
    @LogExecution
    fun postPuntoDeRetiro(@Valid @RequestBody puntoDeRetiroDTO: PuntoDeRetiroDTO): PuntoDeRetiroDTO {
        val newPuntoDeRetiro = puntoDeRetiroService.save(puntoDeRetiroDTO.mapToPuntoDeRetiro())
        return PuntoDeRetiroDTO.Builder(newPuntoDeRetiro).build()
    }

    @PutMapping("/{id}")
    @Throws(PuntoDeRetiroNoExiste::class)
    @LogExecution
    fun updatePuntoDeRetiro(@PathVariable("id") @Valid idPuntoDeRetiro: Long, @Valid @RequestBody puntoDeRetiroDTO: PuntoDeRetiroDTO): PuntoDeRetiroDTO {
        val updatedPuntoDeRetiro = puntoDeRetiroService.update(idPuntoDeRetiro, puntoDeRetiroDTO.mapToPuntoDeRetiro())
        return PuntoDeRetiroDTO.Builder(updatedPuntoDeRetiro).build()
    }

    @DeleteMapping("/{id}")
    @Throws(PuntoDeRetiroNoExiste::class)
    @LogExecution
    fun deletePuntoDeRetiro(@PathVariable("id") @Valid idPuntoDeRetiro: Long): String {
        puntoDeRetiroService.delete(idPuntoDeRetiro)
        return "Punto de Retiro eliminado exitosamente"
    }

}