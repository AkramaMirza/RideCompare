package com.akrama.ridecompare

import com.airbnb.mvrx.MvRxState
import com.google.android.gms.location.places.Place
import com.lyft.lyftbutton.RideParams
import com.uber.sdk.android.rides.RideParameters

data class CompareModel(
        val pickupLocation: Place? = null,
        val destination: Place? = null,

        val lyftRideParams: RideParams? = null,
        val uberRideParams: RideParameters? = null
): MvRxState