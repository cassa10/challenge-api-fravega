package com.example.challengeapifravega.model

import javax.persistence.*

@Entity
@Table(name = "sucursales")
class Sucursal(
        nombre:String,
        ubicacion: Ubicacion,
        @OneToMany(mappedBy = "sucursal", cascade = [CascadeType.ALL], fetch = FetchType.EAGER, orphanRemoval = true)
        var horariosDeAtencion: MutableList<Horario> = mutableListOf(),
        var direccion: String,
        id: Long? = null
) : Nodo(nombre, ubicacion, id) {

    fun addHorario(horario:Horario) {
        horariosDeAtencion.add(horario)
    }

    fun removeHorario(horario:Horario) {
        horariosDeAtencion.remove(horario)
    }

    fun isEmptyHorariosDeAtencion(): Boolean = horariosDeAtencion.isEmpty()

    fun containsHorario(horario:Horario) : Boolean =
            horariosDeAtencion.contains(horario)

    fun update(sucursal: Sucursal){
        nombre = sucursal.nombre
        ubicacion = sucursal.ubicacion
        horariosDeAtencion = sucursal.horariosDeAtencion
        direccion = sucursal.direccion
    }

    data class Builder(
            private var nombre: String = "",
            private var ubicacion: Ubicacion = Ubicacion("0","0"),
            private var horariosDeAtencion: MutableList<Horario> = mutableListOf(),
            private var direccion: String = ""
    ){
        fun build(): Sucursal {
            return Sucursal(nombre, ubicacion, horariosDeAtencion, direccion)
        }

        fun withNombre(nombre: String) = apply { this.nombre = nombre }
        fun withUbicacion(ubicacion: Ubicacion) = apply { this.ubicacion = ubicacion }
        fun withHorariosDeAtencion(horariosDeAtencion: MutableList<Horario>) = apply { this.horariosDeAtencion = horariosDeAtencion }
        fun withDireccion(direccion: String) = apply { this.direccion = direccion }
    }
}