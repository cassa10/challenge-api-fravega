package com.example.challengeapifravega.service

import com.example.challengeapifravega.model.Nodo
import com.example.challengeapifravega.model.Ubicacion

interface NodoService {
    fun getAll() : Collection<Nodo>

    fun getNodoCercano(ubicacion: Ubicacion) : Nodo
}