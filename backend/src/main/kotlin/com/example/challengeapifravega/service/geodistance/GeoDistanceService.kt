package com.example.challengeapifravega.service.geodistance

import com.example.challengeapifravega.model.Nodo
import com.example.challengeapifravega.model.Ubicacion

interface GeoDistanceService {
    fun getNodoCercano(nodos : Collection<Nodo>, ubicacion: Ubicacion): Nodo?
}