package com.akrama.ridecompare

data class CompareViewState(
        val showSetPickupLocationButton: Boolean = true,
        val showSetDestinationButton: Boolean = true,
        val showChangePickupLocationButton: Boolean = false,
        val showChangeDestinationButton: Boolean = false,

        val pickupLocation: String? = null,
        val destination: String? = null
)