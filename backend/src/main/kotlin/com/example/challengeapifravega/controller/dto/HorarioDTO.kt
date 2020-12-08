package com.example.challengeapifravega.controller.dto

import com.example.challengeapifravega.model.Horario
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.DayOfWeek
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.Pattern

class HorarioDTO(
        val dia: DayOfWeek,
        @field:Pattern(regexp = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]\$", message = "{horario.invalido}")
        val apertura: String,
        @field:Pattern(regexp = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]\$", message = "{horario.invalido}")
        val cierre: String
){
    @JsonIgnore
    fun mapToHorario(): Horario {
        return Horario(dia, LocalTime.parse(apertura), LocalTime.parse(cierre))
    }

    data class Builder(val horario: Horario){
        fun build(): HorarioDTO {
            val timeFormat = DateTimeFormatter.ofPattern("HH:mm")
            return HorarioDTO(horario.dia, horario.apertura.format(timeFormat), horario.cierre.format(timeFormat))
        }
    }
}