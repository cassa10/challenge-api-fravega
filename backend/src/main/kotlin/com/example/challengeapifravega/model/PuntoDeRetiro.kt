package com.example.challengeapifravega.model

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "puntosDeRetiros")
class PuntoDeRetiro(
        nombre: String,
        ubicacion: Ubicacion,
        var capacidad: Int,
        id: Long? = null
) : Nodo(nombre, ubicacion, id) {

    fun update(puntoDeRetiro: PuntoDeRetiro){
        nombre = puntoDeRetiro.nombre
        ubicacion = puntoDeRetiro.ubicacion
        capacidad = puntoDeRetiro.capacidad
    }
}