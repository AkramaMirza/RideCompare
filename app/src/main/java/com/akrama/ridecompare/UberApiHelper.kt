package com.akrama.ridecompare

import com.google.android.gms.location.places.Place
import com.uber.sdk.android.core.UberSdk
import com.uber.sdk.android.rides.RideParameters
import com.uber.sdk.rides.client.ServerTokenSession
import com.uber.sdk.rides.client.SessionConfiguration

object UberApiHelper {

    val UBERX_PRODUCT_ID = "a1111c8c-c720-46c3-8534-2fcdd730040d"

    val session by lazy {
        val config = SessionConfiguration.Builder()
                .setClientId(BuildConfig.UBER_CLIENT_ID)
                .setServerToken(BuildConfig.UBER_SERVER_TOKEN)
                .build()
        UberSdk.initialize(config)
        return@lazy ServerTokenSession(config)
    }

    fun buildRideParams(pickupLocation: Place, destination: Place): RideParameters {
        return RideParameters.Builder()
                .setPickupLocation(
                        pickupLocation.latLng.latitude,
                        pickupLocation.latLng.longitude,
                        pickupLocation.name.toString(),
                        pickupLocation.address?.toString()
                )
                .setDropoffLocation(
                        destination.latLng.latitude,
                        destination.latLng.longitude,
                        destination.name.toString(),
                        destination.address?.toString()
                )
                .setProductId(UBERX_PRODUCT_ID)
                .build()
    }
}