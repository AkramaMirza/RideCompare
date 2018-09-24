package com.akrama.ridecompare

import com.airbnb.mvrx.BaseMvRxViewModel
import com.google.android.gms.location.places.Place

class CompareViewModel(initialState: CompareModel): BaseMvRxViewModel<CompareModel>(initialState, false) {

    fun setPickupLocation(place: Place) {
        setState { copy(pickupLocation = place) }
    }

    fun setDestination(place: Place) {
        setState { copy(destination = place) }
    }

}