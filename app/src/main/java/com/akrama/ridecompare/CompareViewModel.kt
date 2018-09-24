package com.akrama.ridecompare

import com.airbnb.mvrx.BaseMvRxViewModel
import com.google.android.gms.location.places.Place

class CompareViewModel(initialState: CompareModel): BaseMvRxViewModel<CompareModel>(initialState, false) {

    init {
        selectSubscribe(CompareModel::pickupLocation, CompareModel::destination) { pickupLocation, destination ->

            if (pickupLocation == null || destination == null) return@selectSubscribe

            val lyftRideParams = LyftApiHelper.buildRideParams(pickupLocation, destination)
            val uberRideParams = UberApiHelper.buildRideParams(pickupLocation, destination)

            setState { copy(lyftRideParams = lyftRideParams, uberRideParams = uberRideParams) }
        }
    }

    fun setPickupLocation(place: Place) {
        setState { copy(pickupLocation = place) }
    }

    fun setDestination(place: Place) {
        setState { copy(destination = place) }
    }

}