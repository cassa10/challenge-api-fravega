package com.example.challengeapifravega.service.impl

import com.example.challengeapifravega.exception.SucursalNoExiste
import com.example.challengeapifravega.model.Sucursal
import com.example.challengeapifravega.persistence.SucursalDAO
import com.example.challengeapifravega.service.SucursalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class SucursalServiceImpl(@Autowired val sucursalDAO: SucursalDAO) : SucursalService {

    override fun get(id: Long): Optional<Sucursal> {
        return sucursalDAO.get(id)
    }

    override fun getAll(): Collection<Sucursal> {
        return sucursalDAO.getAll()
    }

    override fun save(t: Sucursal): Sucursal {
        return sucursalDAO.save(t)
    }

    override fun update(id: Long, t: Sucursal): Sucursal {
        val savedSucursal = this.validateIfExistAndReturn(get(id))
        savedSucursal.update(t)
        return sucursalDAO.update(savedSucursal)
    }

    override fun delete(id: Long) {
        this.validateIfExistAndReturn(get(id))
        return sucursalDAO.delete(id)
    }

    override fun validateIfExistAndReturn(maybeT: Optional<Sucursal>): Sucursal {
        if(! maybeT.isPresent)
            throw SucursalNoExiste()
        return maybeT.get()
    }
}