package com.example.challengeapifravega.persistence.impl.repositories

import com.example.challengeapifravega.model.PuntoDeRetiro
import com.example.challengeapifravega.persistence.PuntoDeRetiroDAO
import com.example.challengeapifravega.persistence.impl.repositories.impl.PuntoDeRetiroRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PuntoDeRetiroRepositoryDAO(@Autowired val puntoDeRetiroRepository: PuntoDeRetiroRepository) : PuntoDeRetiroDAO {

    override fun get(id: Long): Optional<PuntoDeRetiro> {
        return puntoDeRetiroRepository.findById(id)
    }

    override fun getAll(): Collection<PuntoDeRetiro> {
        return puntoDeRetiroRepository.findAll()
    }

    override fun save(t: PuntoDeRetiro): PuntoDeRetiro {
        return puntoDeRetiroRepository.save(t)
    }

    override fun update(t: PuntoDeRetiro): PuntoDeRetiro {
        return puntoDeRetiroRepository.save(t)
    }

    override fun delete(id: Long) {
        val puntoDeRetiro = puntoDeRetiroRepository.getOne(id)
        puntoDeRetiroRepository.delete(puntoDeRetiro)
    }

}