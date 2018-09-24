package com.akrama.ridecompare

import com.airbnb.mvrx.BaseMvRxViewModel

class CompareViewModel(initialState: CompareState): BaseMvRxViewModel<CompareState>(initialState, false) {

    init {
        setState {
            copy(pickupLocationString = "My pickup location", destinationString = "My destination")
        }
    }

}