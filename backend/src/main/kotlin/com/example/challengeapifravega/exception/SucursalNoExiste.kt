package com.example.challengeapifravega.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.Exception

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "La Sucursal no existe")
class SucursalNoExiste : Exception("La Sucursal no existe")