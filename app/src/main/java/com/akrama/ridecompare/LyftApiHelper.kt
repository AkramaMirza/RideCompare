package com.akrama.ridecompare

import com.lyft.networking.ApiConfig

object LyftApiHelper {

    val apiConfig by lazy {
        ApiConfig.Builder()
                .setClientId("2WSZcX3f_GrG")
                .setClientToken("jOO3XTHtMp4y9PBcSp3BgrA9UWwRNPbUa9r1qQp39Pj8JsgAEf4KMmtCdiZvHTd30QOjMQhmkcBsrUruMtIkzU/Vsm2HFNYXJW6UjkU1+pj1a1/kadb5fAE=")
                .build()
    }
}