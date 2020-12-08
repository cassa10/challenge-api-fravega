package com.example.challengeapifravega.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.OK, reason = "No existen nodos disponibles")
class NodosInexistentes : Exception("No existen nodos disponibles")