package com.example.challengeapifravega.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Embeddable

@Embeddable
class Ubicacion(var latitude:String, var longitude:String) {

    @Suppress("JpaAttributeMemberSignatureInspection")
    fun getLatitudeAsDouble():Double = latitude.toDouble()

    @Suppress("JpaAttributeMemberSignatureInspection")
    fun getLongitudeAsDouble():Double = longitude.toDouble()

}