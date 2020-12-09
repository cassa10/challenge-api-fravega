package com.example.challengeapifravega.model

import javax.persistence.Embeddable

@Embeddable
class Ubicacion(var latitude:String, var longitude:String) {

    @Suppress("JpaAttributeMemberSignatureInspection")
    fun getLatitudeAsDouble():Double = latitude.toDouble()

    @Suppress("JpaAttributeMemberSignatureInspection")
    fun getLongitudeAsDouble():Double = longitude.toDouble()

    override fun equals(other: Any?): Boolean =
            (other is Ubicacion)
            && latitude == other.latitude
            && longitude == other.longitude
}