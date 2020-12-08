package com.example.challengeapifravega.service.impl

import com.example.challengeapifravega.model.Nodo
import com.example.challengeapifravega.model.Ubicacion
import com.example.challengeapifravega.service.NodoService
import com.example.challengeapifravega.service.PuntoDeRetiroService
import com.example.challengeapifravega.service.SucursalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NodoServiceImpl(
        @Autowired val puntoDeRetiroService: PuntoDeRetiroService,
        @Autowired val sucursalService: SucursalService
) : NodoService {

    //TODO
    //  Mejora: reducir a una query de BBDD
    override fun getAll(): Collection<Nodo> {
        val nodos = mutableListOf<Nodo>()
        nodos.addAll(puntoDeRetiroService.getAll())
        nodos.addAll(sucursalService.getAll())
        return nodos
    }

    override fun getNodoCercano(ubicacion: Ubicacion): Nodo {
        TODO("Not yet implemented")
    }
}