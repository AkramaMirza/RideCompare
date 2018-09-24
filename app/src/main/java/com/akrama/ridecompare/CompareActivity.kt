package com.akrama.ridecompare

import android.os.Bundle
import com.airbnb.mvrx.*

class CompareActivity : BaseMvRxActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compare)
    }
}
