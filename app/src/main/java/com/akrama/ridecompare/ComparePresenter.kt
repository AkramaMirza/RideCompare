package com.akrama.ridecompare

object ComparePresenter {

    fun toViewState(dataModel: CompareModel): CompareViewState {
        val isPickupLocationSelected = dataModel.pickupLocation != null
        val isDestinationSelected = dataModel.destination != null

        return CompareViewState(
                showSetPickupLocationButton = !isPickupLocationSelected,
                showSetDestinationButton = !isDestinationSelected,
                showChangePickupLocationButton = isPickupLocationSelected,
                showChangeDestinationButton = isDestinationSelected,

                pickupLocation = dataModel.pickupLocation?.address.toString(),
                destination = dataModel.destination?.address.toString()
        )
    }
}