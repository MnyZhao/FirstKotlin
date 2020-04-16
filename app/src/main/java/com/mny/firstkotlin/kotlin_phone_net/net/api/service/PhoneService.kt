package com.mny.firstkotlin.kotlin_phone_net.net.api.service

import com.mny.firstkotlin.kotlin_phone_net.net.model.respmodel.HttpResult
import com.mny.firstkotlin.kotlin_phone_net.net.model.respmodel.RespPhoneInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface PhoneService {
    @GET("mobile/get")
    suspend fun getPhoneAscription(@Query("phone") phone: String, @Query("key") key: String): HttpResult<RespPhoneInfo>
}