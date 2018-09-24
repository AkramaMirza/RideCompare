package com.akrama.ridecompare

import com.airbnb.mvrx.MvRxState
import com.google.android.gms.maps.model.LatLng

data class CompareModel(
        val pickupLocationLatLng: LatLng? = null,
        val destinationLatLng: LatLng? = null
): MvRxState