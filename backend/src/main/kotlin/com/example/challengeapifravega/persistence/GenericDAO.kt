package com.example.challengeapifravega.persistence

import java.util.Optional

interface GenericDAO<T> {
    fun get(id:Long): Optional<T>
    fun getAll():Collection<T>
    fun save(t:T):T
    fun update(t:T):T
    fun delete(id:Long)
}