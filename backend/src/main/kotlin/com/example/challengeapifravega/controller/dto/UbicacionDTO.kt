package com.example.challengeapifravega.controller.dto

import com.example.challengeapifravega.model.Ubicacion
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.validation.constraints.Pattern

class UbicacionDTO(
        @field:Pattern(regexp = "-?[1-9][0-9]*(\\.[0-9]+)?", message = "{coord.invalida}")
        val latitude:String,
        @field:Pattern(regexp = "-?[1-9][0-9]*(\\.[0-9]+)?", message = "{coord.invalida}")
        val longitude:String
){

    @JsonIgnore
    fun mapToUbicacion(): Ubicacion{
        return Ubicacion(latitude, longitude)
    }

    data class Builder(val ubicacion: Ubicacion) {
        fun build() : UbicacionDTO {
            return UbicacionDTO(ubicacion.latitude, ubicacion.longitude)
        }
    }
}