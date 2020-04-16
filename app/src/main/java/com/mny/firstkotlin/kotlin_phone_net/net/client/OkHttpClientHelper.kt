package com.mny.firstkotlin.kotlin_phone_net.net.client

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object OkHttpClientHelper {
    const val CONNECTION_TIMEOUT:Long=10
    const val READ_TIMEOUT:Long=10
    fun getOkhttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }
}