package com.example.challengeapifravega.controller.dto

import com.example.challengeapifravega.model.Sucursal
import com.fasterxml.jackson.annotation.JsonIgnore
import com.sun.istack.NotNull
import org.hibernate.validator.constraints.Length
import javax.validation.Valid

class SucursalDTO(
        @field:Length(min = 2, max=30, message = "{nombre.size}")
        val nombre:String,
        @field:Valid var ubicacion: UbicacionDTO,
        @field:Valid var horariosDeAtencion: MutableList<HorarioDTO>,
        @field:Length(min = 5, max=150, message = "{direccion.size}")
        val direccion: String? = null,
        val id: Long? = null
) {
    @JsonIgnore
    fun mapToSucursal(): Sucursal {
        val horariosDeAtencionModel = horariosDeAtencion.map { it.mapToHorario() }
        return Sucursal(nombre,ubicacion.mapToUbicacion(), horariosDeAtencionModel.toMutableList(), direccion)
    }

    data class Builder(val sucursal: Sucursal){
        fun build(): SucursalDTO {
            return SucursalDTO(
                    sucursal.nombre,
                    UbicacionDTO.Builder(sucursal.ubicacion).build(),
                    sucursal.horariosDeAtencion.map { HorarioDTO.Builder(it).build() }.toMutableList(),
                    sucursal.direccion,
                    sucursal.id
            )
        }
    }
}