package com.example.challengeapifravega.model

import javax.persistence.*

@Entity
@Table(name = "sucursales")
class Sucursal(
        nombre:String,
        ubicacion: Ubicacion,
        @ElementCollection
        var horariosDeAtencion: MutableList<Horario> = mutableListOf(),
        var direccion: String
) : Nodo(nombre, ubicacion) {

    fun addHorario(horario:Horario) {
        horariosDeAtencion.add(horario)
    }

    fun removeHorario(horario:Horario) {
        horariosDeAtencion.remove(horario)
    }
}