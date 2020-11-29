package com.example.challengeapifravega.service

import java.util.*

interface GenericService<T> {

    fun get(id:Long): Optional<T>
    fun getAll():Collection<T>
    fun save(t:T):T
    fun update(id:Long, t:T):T
    fun delete(id:Long)
    fun validateIfExistAndReturn(maybeT: Optional<T>) : T
}
