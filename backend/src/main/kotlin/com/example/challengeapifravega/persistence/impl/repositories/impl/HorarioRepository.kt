package com.example.challengeapifravega.persistence.impl.repositories.impl

import com.example.challengeapifravega.model.Horario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HorarioRepository : JpaRepository<Horario, Long> {
}