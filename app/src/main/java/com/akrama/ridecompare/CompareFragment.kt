package com.akrama.ridecompare


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState

class CompareFragment : BaseMvRxFragment() {

    private val compareViewModel: CompareViewModel by fragmentViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_compare, container, false)
    }

    override fun invalidate() {
        withState(compareViewModel) {
            Log.d("CompareFragment", "Pickup location: ${it.pickupLocationString}")
        }
    }

}
