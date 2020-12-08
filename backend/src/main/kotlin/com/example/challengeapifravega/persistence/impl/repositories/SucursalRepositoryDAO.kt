package com.example.challengeapifravega.persistence.impl.repositories

import com.example.challengeapifravega.model.Sucursal
import com.example.challengeapifravega.persistence.SucursalDAO
import com.example.challengeapifravega.persistence.impl.repositories.impl.SucursalRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class SucursalRepositoryDAO(@Autowired val sucursalRepository : SucursalRepository) : SucursalDAO {

    override fun get(id: Long): Optional<Sucursal> {
        return sucursalRepository.findById(id)
    }

    override fun getAll(): Collection<Sucursal> {
        return sucursalRepository.findAll()
    }

    override fun save(t: Sucursal): Sucursal {
        return sucursalRepository.save(t)
    }

    override fun update(t: Sucursal): Sucursal {
        return sucursalRepository.save(t)
    }

    override fun delete(id: Long) {
        val sucursal = sucursalRepository.getOne(id)
        sucursalRepository.delete(sucursal)
    }
}