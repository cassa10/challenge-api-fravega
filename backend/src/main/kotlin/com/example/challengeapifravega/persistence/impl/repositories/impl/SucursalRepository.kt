package com.example.challengeapifravega.persistence.impl.repositories.impl

import com.example.challengeapifravega.model.Sucursal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SucursalRepository : JpaRepository<Sucursal, Long> {
}