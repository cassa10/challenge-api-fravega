package com.example.challengeapifravega

import com.example.challengeapifravega.model.Ubicacion
import com.example.challengeapifravega.service.geodistance.GeoDistance
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GeoDistanceTest{

    private val geoDistance : GeoDistance = GeoDistance()

    @Test
    fun testDadaLaMismaCoordenadaLaDistanciaEs0TantoEnKMComoEnMillas(){

        Assertions.assertEquals(geoDistance.distanciaCoordEnKM(-34.706566,-58.277687,-34.706566,-58.277687)
                ,0.0)

        Assertions.assertEquals(geoDistance.distanciaCoordEnMillas(-34.706566,-58.277687,-34.706566,-58.277687)
                ,0.0)

        //Misma distancia si cambio el orden
        Assertions.assertEquals(geoDistance.distanciaCoordEnKM(-34.706566,-58.277687,-34.706566,-58.277687)
                ,0.0)

        Assertions.assertEquals(geoDistance.distanciaCoordEnMillas(-34.706566,-58.277687,-34.706566,-58.277687)
                ,0.0)
    }

    @Test
    fun testDadaDosCoordenadasLaDistanciaEntreEllasEs1Punto26KmY0Punto78Millas(){

        //Coord1
        //-34.706566, -58.277687

        //Coord2
        //-34.698114, -58.286888

        Assertions.assertEquals(geoDistance.distanciaCoordEnKM(-34.706566,-58.277687,-34.698114,-58.286888)
                ,1.26)

        Assertions.assertEquals(geoDistance.distanciaCoordEnMillas(-34.706566,-58.277687,-34.698114,-58.286888)
                ,0.78)

        //Misma distancia si cambio el orden
        Assertions.assertEquals(geoDistance.distanciaCoordEnKM(-34.698114,-58.286888,-34.706566,-58.277687)
                ,1.26)

        Assertions.assertEquals(geoDistance.distanciaCoordEnMillas(-34.698114,-58.286888,-34.706566,-58.277687)
                ,0.78)
    }

    @Test
    fun testDadaUnaUbicacionEnLaUNQYOtraUbicacionEnMarDelPlataLaDistanciaEntreEllasEs372Punto65KmY231Punto55Millas(){

        //UNQ (Universidad Nacional de Quilmes)
        val unq = Ubicacion("-34.706416","-58.278559")

        //Mar del Plata (mdq)
        val mdq = Ubicacion("-38.005004","-57.542606")

        //Delta 0.001km distancia de tolerancia
        val distanciaDeTolerancia = 0.001

        Assertions.assertEquals(geoDistance.distanciaUbicacionesEnKM(unq,mdq),372.66,distanciaDeTolerancia)

        Assertions.assertEquals(geoDistance.distanciaUbicacionesEnMillas(unq,mdq),231.56,distanciaDeTolerancia)

        //Misma distancia si cambio el orden

        Assertions.assertEquals(geoDistance.distanciaUbicacionesEnKM(mdq,unq),372.66,distanciaDeTolerancia)

        Assertions.assertEquals(geoDistance.distanciaUbicacionesEnMillas(mdq,unq),231.56, distanciaDeTolerancia)
    }


}