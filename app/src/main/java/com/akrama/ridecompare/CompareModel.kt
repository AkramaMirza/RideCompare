package com.akrama.ridecompare

import com.airbnb.mvrx.MvRxState
import com.google.android.gms.location.places.Place

data class CompareModel(
        val pickupLocation: Place? = null,
        val destination: Place? = null
): MvRxState