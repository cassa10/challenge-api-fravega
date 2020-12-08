package com.example.challengeapifravega.persistence.impl.repositories.impl

import com.example.challengeapifravega.model.PuntoDeRetiro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PuntoDeRetiroRepository : JpaRepository<PuntoDeRetiro, Long>