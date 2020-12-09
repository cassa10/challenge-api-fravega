package com.example.challengeapifravega

import com.example.challengeapifravega.model.Horario
import com.example.challengeapifravega.model.Sucursal
import com.example.challengeapifravega.model.Ubicacion
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.DayOfWeek
import java.time.LocalTime

class SucursalTest {

    @Test
    fun testCreateSuccessfullyASucursal(){
        val horariosDeAtencionSucursal1 = mutableListOf<Horario>()
        horariosDeAtencionSucursal1.add(Horario(DayOfWeek.MONDAY, LocalTime.of(13,15), LocalTime.of(23,0)))
        horariosDeAtencionSucursal1.add(Horario(DayOfWeek.WEDNESDAY, LocalTime.of(9,0), LocalTime.of(18,15)))

        val sucursal1 = Sucursal.Builder().
            withNombre("Sucursal 1").
            withDireccion("Mitre 203").
            withUbicacion(Ubicacion("23.123123","23.123123")).
            withHorariosDeAtencion(horariosDeAtencionSucursal1)
            .build()

        val sucursal2 = Sucursal.Builder().
            withNombre("Sucursal 2").
            withDireccion("Av. Mayo 123").
            withUbicacion(Ubicacion("23.123123","-13.123123"))
            .build()

        Assert.assertEquals(sucursal1.nombre,"Sucursal 1")
        Assert.assertEquals(sucursal2.nombre,"Sucursal 2")

        Assert.assertEquals(sucursal1.direccion,"Mitre 203")
        Assert.assertEquals(sucursal2.direccion,"Av. Mayo 123")

        Assert.assertEquals(sucursal1.ubicacion, Ubicacion("23.123123","23.123123"))
        Assert.assertEquals(sucursal2.ubicacion, Ubicacion("23.123123","-13.123123"))

        Assert.assertFalse(sucursal1.isEmptyHorariosDeAtencion())
        Assert.assertTrue(sucursal1.containsHorario(Horario(DayOfWeek.MONDAY, LocalTime.of(13,15), LocalTime.of(23,0))))
        Assert.assertTrue(sucursal1.containsHorario(Horario(DayOfWeek.WEDNESDAY, LocalTime.of(9,0), LocalTime.of(18,15))))
        Assert.assertFalse(sucursal1.containsHorario(Horario(DayOfWeek.WEDNESDAY, LocalTime.of(9,0), LocalTime.of(18,16))))
        Assert.assertFalse(sucursal1.containsHorario(Horario(DayOfWeek.WEDNESDAY, LocalTime.of(9,1), LocalTime.of(18,15))))
        Assert.assertFalse(sucursal1.containsHorario(Horario(DayOfWeek.TUESDAY, LocalTime.of(9,0), LocalTime.of(18,15))))


        Assert.assertTrue(sucursal2.isEmptyHorariosDeAtencion())
    }

    @Test
    fun testCreateUnsuccessfullyASucursal(){
        assertThrows<NullPointerException> {
            val sucursal = Sucursal(null!!, Ubicacion("12.123123","-12.123123"), mutableListOf(), "Mitre 103")
            Assert.assertNotNull(sucursal.nombre)
        }

    }
}