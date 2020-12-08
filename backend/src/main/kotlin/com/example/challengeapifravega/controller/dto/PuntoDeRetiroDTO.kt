package com.example.challengeapifravega.controller.dto

import com.example.challengeapifravega.model.PuntoDeRetiro
import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.validator.constraints.Length
import javax.validation.Valid
import javax.validation.constraints.Max
import javax.validation.constraints.Min

class PuntoDeRetiroDTO(
        @field:Length(min = 2, max = 30, message = "{nombre.size}")
        val nombre: String,
        @field:Valid
        val ubicacion: UbicacionDTO,
        @field:Min(value = 1, message = "{capacidad.min}")
        @field:Max(value = 9999999, message = "{capacidad.max}")
        val capacidad: Int,
        var id: Long? = null
) {

    @JsonIgnore
    fun mapToPuntoDeRetiro() : PuntoDeRetiro {
        return PuntoDeRetiro(nombre,ubicacion.mapToUbicacion(), capacidad)
    }

    data class Builder(val puntoDeRetiro: PuntoDeRetiro) {
        fun build(): PuntoDeRetiroDTO {
            return PuntoDeRetiroDTO(
                    puntoDeRetiro.nombre,
                    UbicacionDTO.Builder(puntoDeRetiro.ubicacion).build(),
                    puntoDeRetiro.capacidad,
                    puntoDeRetiro.id
            )
        }
    }

}