package com.akrama.ridecompare

import com.google.android.gms.location.places.Place
import com.lyft.lyftbutton.RideParams
import com.lyft.lyftbutton.RideTypeEnum
import com.lyft.networking.ApiConfig

object LyftApiHelper {

    val apiConfig by lazy {
        ApiConfig.Builder()
                .setClientId(BuildConfig.LYFT_CLIENT_ID)
                .setClientToken(BuildConfig.LYFT_CLIENT_TOKEN)
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