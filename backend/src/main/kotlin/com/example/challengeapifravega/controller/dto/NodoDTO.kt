package com.example.challengeapifravega.controller.dto

import com.example.challengeapifravega.model.Nodo
import org.hibernate.validator.constraints.Length
import javax.validation.Valid

class NodoDTO(
        @field:Length(min = 2, max=30, message = "{nombre.size}")
        val nombre:String,
        @field:Valid var ubicacion: UbicacionDTO,
        val id: Long? = null
){
    data class Builder(val nodo:Nodo){
        fun build(): NodoDTO {
            return NodoDTO(nodo.nombre, UbicacionDTO.Builder(nodo.ubicacion).build(), nodo.id)
        }
    }
}