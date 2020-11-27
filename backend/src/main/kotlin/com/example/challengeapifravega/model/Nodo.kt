package com.example.challengeapifravega.model

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
abstract class Nodo (
        var nombre: String,
        var ubicacion: Ubicacion,
        @Id @GeneratedValue var id: Long? = null
){
}