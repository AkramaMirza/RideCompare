package com.akrama.ridecompare


import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.google.android.gms.location.places.ui.PlacePicker
import kotlinx.android.synthetic.main.fragment_compare.*

class CompareFragment : BaseMvRxFragment() {

    companion object {
        const val PICKUP_PICKER_REQUEST_CODE = 1
        const val DESTINATION_REQUEST_CODE = 2
    }

    private val compareViewModel: CompareViewModel by fragmentViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_compare, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        selectPickupLocationButton.setOnClickListener { openPickupLocationPicker() }
        selectDestinationButton.setOnClickListener { openDestinationPicker() }
        lyftButton.setApiConfig(LyftApiHelper.apiConfig)
        uberButton.setSession(UberApiHelper.session)
    }

    override fun invalidate() {
        compareViewModel.toViewState {
            pickupLocation?.let { selectPickupLocationButton.text = it }
            destination?.let { selectDestinationButton.text = it }
        }

        withState(compareViewModel) { dataModel ->
            dataModel.lyftRideParams?.let {
                lyftButton.setRideParams(it)
                lyftButton.load()
            }
            dataModel.uberRideParams?.let {
                uberButton.setRideParameters(it)
                uberButton.loadRideInformation()
            }
        }
    }

    private fun openPickupLocationPicker() = openPlacePicker(PICKUP_PICKER_REQUEST_CODE)

    private fun openDestinationPicker() = openPlacePicker(DESTINATION_REQUEST_CODE)

    private fun openPlacePicker(requestCode: Int) {
        startActivityForResult(PlacePicker.IntentBuilder().build(requireActivity()), requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RESULT_OK && data != null) {
            val place = PlacePicker.getPlace(context, data)
            when(requestCode) {
                PICKUP_PICKER_REQUEST_CODE -> compareViewModel.setPickupLocation(place)
                DESTINATION_REQUEST_CODE -> compareViewModel.setDestination(place)
            }
        }
    }

}
