package com.mny.firstkotlin.kotlin_phone_net.net.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(OkHttpClientHelper.getOkhttpClient())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}