package com.example.challengeapifravega.controller.dto

import com.example.challengeapifravega.model.Horario
import com.fasterxml.jackson.annotation.JsonIgnore
import com.sun.istack.NotNull
import java.time.DayOfWeek
import java.time.LocalTime

class HorarioDTO(
        @NotNull val dia: DayOfWeek,
        @NotNull val apertura: LocalTime,
        @NotNull val cierre: LocalTime
){
    @JsonIgnore
    fun mapToHorario(): Horario {
        return Horario(dia, apertura, cierre)
    }

    data class Builder(val horario: Horario){
        fun build(): HorarioDTO {
            return HorarioDTO(horario.dia, horario.apertura, horario.cierre)
        }
    }
}