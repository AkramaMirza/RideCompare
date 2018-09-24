package com.akrama.ridecompare

fun CompareViewModel.toViewState(block: (CompareViewState) -> Unit) {
    com.airbnb.mvrx.withState(this) {
        ComparePresenter.toViewState(it).let(block)
    }
}