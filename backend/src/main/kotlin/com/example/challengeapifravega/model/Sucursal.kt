package com.example.challengeapifravega.model

import javax.persistence.*

@Entity
@Table(name = "sucursales")
class Sucursal(
        nombre:String,
        ubicacion: Ubicacion,
        @OneToMany(mappedBy = "sucursal", cascade = [CascadeType.ALL], fetch = FetchType.EAGER, orphanRemoval = true)
        var horariosDeAtencion: MutableList<Horario> = mutableListOf(),
        var direccion: String? = null,
        id: Long? = null
) : Nodo(nombre, ubicacion, id) {

    fun addHorario(horario:Horario) {
        horariosDeAtencion.add(horario)
    }

    fun removeHorario(horario:Horario) {
        horariosDeAtencion.remove(horario)
    }

    fun update(sucursal: Sucursal){
        nombre = sucursal.nombre
        ubicacion = sucursal.ubicacion
        horariosDeAtencion = sucursal.horariosDeAtencion
        direccion = sucursal.direccion
    }
}