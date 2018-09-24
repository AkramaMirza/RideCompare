package com.akrama.ridecompare

import com.google.android.gms.location.places.Place
import com.lyft.lyftbutton.RideParams
import com.lyft.lyftbutton.RideTypeEnum
import com.lyft.networking.ApiConfig

object LyftApiHelper {

    val apiConfig by lazy {
        ApiConfig.Builder()
                .setClientId("2WSZcX3f_GrG")
                .setClientToken("jOO3XTHtMp4y9PBcSp3BgrA9UWwRNPbUa9r1qQp39Pj8JsgAEf4KMmtCdiZvHTd30QOjMQhmkcBsrUruMtIkzU/Vsm2HFNYXJW6UjkU1+pj1a1/kadb5fAE=")
                .build()
    }

    fun buildRideParams(pickupLocation: Place, destination: Place): RideParams {
        return RideParams.Builder()
                .setPickupLocation(pickupLocation.latLng.latitude, pickupLocation.latLng.longitude)
                .setDropoffLocation(destination.latLng.latitude, destination.latLng.longitude)
                .setRideTypeEnum(RideTypeEnum.CLASSIC)
                .build()
    }
}