package com.akrama.ridecompare

import com.airbnb.mvrx.MvRxState

data class CompareState(
        val pickupLocationString: String = "",
        val destinationString: String = ""
): MvRxState