package com.mny.firstkotlin.kotlin_phone_net.net.api.service

import com.mny.firstkotlin.kotlin_phone_net.net.client.RetrofitHelper

const val base_url = "http://apis.juhe.cn/"

object ApiService {
    fun getPhoneService(): PhoneService {
        return RetrofitHelper.getRetrofit(base_url).create(
            PhoneService::class.java)
    }
}