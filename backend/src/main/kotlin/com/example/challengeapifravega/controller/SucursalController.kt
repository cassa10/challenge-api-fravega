package com.example.challengeapifravega.controller

import com.example.challengeapifravega.controller.dto.SucursalDTO
import com.example.challengeapifravega.exception.SucursalNoExiste
import com.example.challengeapifravega.service.SucursalService
import com.example.challengeapifravega.service.logger.LogExecution
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/sucursal")
@Validated
class SucursalController(@Autowired val sucursalService: SucursalService) {

    @GetMapping
    @LogExecution
    fun getAllSucursal(): List<SucursalDTO> {
        return sucursalService.getAll().map { SucursalDTO.Builder(it).build() }
    }


    @GetMapping("/{id}")
    @Throws(SucursalNoExiste::class)
    @LogExecution
    fun getSucursal(@PathVariable("id") @Valid idSucursal: Long): SucursalDTO {
        val maybeSucursal = sucursalService.get(idSucursal)
        return SucursalDTO.Builder(sucursalService.validateIfExistAndReturn(maybeSucursal)).build()
    }

    @PostMapping
    @LogExecution
    fun postSucursal(@Valid @RequestBody sucursalDTO: SucursalDTO): SucursalDTO {
        val newSucursal = sucursalService.save(sucursalDTO.mapToSucursal())
        return SucursalDTO.Builder(newSucursal).build()
    }

    @PutMapping("/{id}")
    @Throws(SucursalNoExiste::class)
    @LogExecution
    fun updateSucursal(@PathVariable("id") @Valid idSucursal: Long, @Valid @RequestBody sucursalDTO: SucursalDTO): SucursalDTO {
        val updatedSucursal = sucursalService.update(idSucursal, sucursalDTO.mapToSucursal())
        return SucursalDTO.Builder(updatedSucursal).build()
    }

    @DeleteMapping("/{id}")
    @Throws(SucursalNoExiste::class)
    @LogExecution
    fun deleteSucursal(@PathVariable("id") @Valid idSucursal: Long): String {
        sucursalService.delete(idSucursal)
        return "Sucursal eliminada exitosamente"
    }
}