package com.akrama.ridecompare

object ComparePresenter {

    fun toViewState(dataModel: CompareModel): CompareViewState {
        return CompareViewState(
                pickupLocation = dataModel.pickupLocation?.address?.toString(),
                destination = dataModel.destination?.address?.toString()
        )
    }
}