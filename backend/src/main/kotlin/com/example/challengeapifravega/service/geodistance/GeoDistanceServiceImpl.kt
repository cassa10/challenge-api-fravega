package com.example.challengeapifravega.service.geodistance

import com.example.challengeapifravega.model.Nodo
import com.example.challengeapifravega.model.Ubicacion

class GeoDistanceServiceImpl(private val geodistance: GeoDistance = GeoDistance()) : GeoDistanceService {

    override fun getNodoCercano(nodos: Collection<Nodo>, ubicacion: Ubicacion): Nodo? {
        return nodos.minBy { geodistance.distanciaUbicacionesEnKM(it.ubicacion, ubicacion) }
    }
}