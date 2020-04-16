package com.mny.firstkotlin.kotlin_phone_net.net.api.source

import com.mny.firstkotlin.kotlin_phone_net.net.api.Result
import com.mny.firstkotlin.kotlin_phone_net.net.model.respmodel.HttpResult
import com.mny.firstkotlin.kotlin_phone_net.net.model.respmodel.RespPhoneInfo

interface PhoneSource {
    // 返回错误处理类 便于 处理请求成功 or 失败
    suspend fun getPhoneAscription(phone: String, key: String): Result<RespPhoneInfo>
}