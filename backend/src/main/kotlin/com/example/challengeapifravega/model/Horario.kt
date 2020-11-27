package com.example.challengeapifravega.model

import java.time.DayOfWeek
import java.time.LocalTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Horario(
        var dia:DayOfWeek,
        var apertura:LocalTime,
        var cierre:LocalTime,
        @Id @GeneratedValue var id: Long? = null)
{

}