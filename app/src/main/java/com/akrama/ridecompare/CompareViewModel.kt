package com.akrama.ridecompare

import com.airbnb.mvrx.BaseMvRxViewModel

class CompareViewModel(initialState: CompareModel): BaseMvRxViewModel<CompareModel>(initialState, false) {

}

fun CompareViewModel.toViewState(block: (CompareViewState) -> Unit) {
    com.airbnb.mvrx.withState(this) {
        ComparePresenter.toViewState(it).let(block)
    }
}