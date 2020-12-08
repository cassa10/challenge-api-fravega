package com.example.challengeapifravega.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "El Punto de Retiro no existe")
class PuntoDeRetiroNoExiste : Exception("El Punto de Retiro no existe")