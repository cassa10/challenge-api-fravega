package com.example.challengeapifravega.model

import java.time.DayOfWeek
import java.time.LocalTime
import javax.persistence.*

@Entity
class Horario(
        var dia:DayOfWeek,
        var apertura:LocalTime,
        var cierre:LocalTime,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "sucursal_id")
        var sucursal: Sucursal? = null,
        @Id @GeneratedValue var id: Long? = null
)