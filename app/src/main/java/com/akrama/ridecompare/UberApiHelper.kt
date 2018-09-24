package com.akrama.ridecompare

import com.uber.sdk.android.core.UberSdk
import com.uber.sdk.rides.client.SessionConfiguration

object UberApiHelper {

    fun initUberApi() {
        UberSdk.initialize(SessionConfiguration.Builder()
                .setClientId("3Yl5e6RFV_5-1IRPNH7bLDJ-9zD-JO8N")
                .setServerToken("_fPScDJea92vIXTjP8umctyDEwxUQUe0aGN4V285")
                .build())
    }
}