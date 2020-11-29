package com.example.challengeapifravega.service.impl

import com.example.challengeapifravega.exception.PuntoDeRetiroNoExiste
import com.example.challengeapifravega.model.PuntoDeRetiro
import com.example.challengeapifravega.persistence.PuntoDeRetiroDAO
import com.example.challengeapifravega.service.PuntoDeRetiroService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PuntoDeRetiroServiceImpl(@Autowired val puntoDeRetiroDAO: PuntoDeRetiroDAO) : PuntoDeRetiroService {

    override fun get(id: Long): Optional<PuntoDeRetiro> {
        return puntoDeRetiroDAO.get(id)
    }

    override fun getAll(): Collection<PuntoDeRetiro> {
        return puntoDeRetiroDAO.getAll()
    }

    override fun save(t: PuntoDeRetiro): PuntoDeRetiro {
        return puntoDeRetiroDAO.save(t)
    }

    override fun update(id: Long, t: PuntoDeRetiro): PuntoDeRetiro {
        val savedPuntoDeRetiro = this.validateIfExistAndReturn(get(id))
        savedPuntoDeRetiro.update(t)
        return puntoDeRetiroDAO.update(savedPuntoDeRetiro)
    }

    override fun delete(id: Long) {
        this.validateIfExistAndReturn(get(id))
        return puntoDeRetiroDAO.delete(id)
    }

    override fun validateIfExistAndReturn(maybeT: Optional<PuntoDeRetiro>): PuntoDeRetiro {
        if(! maybeT.isPresent)
            throw PuntoDeRetiroNoExiste()
        return maybeT.get()
    }
}