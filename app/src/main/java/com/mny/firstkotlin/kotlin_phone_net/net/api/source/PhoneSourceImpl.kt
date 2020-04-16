package com.mny.firstkotlin.kotlin_phone_net.net.api.source

import com.mny.firstkotlin.kotlin_phone_net.net.api.service.ApiService
import com.mny.firstkotlin.kotlin_phone_net.net.api.BaseRepository
import com.mny.firstkotlin.kotlin_phone_net.net.api.Result
import com.mny.firstkotlin.kotlin_phone_net.net.model.respmodel.RespPhoneInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PhoneSourceImpl : PhoneSource, BaseRepository() {
    // 返回错误处理类 便于 处理请求成功 or 失败
    override suspend fun getPhoneAscription(phone: String, key: String): Result<RespPhoneInfo> {
        return safeApiCall {
            withContext(Dispatchers.IO) {
                ApiService.getPhoneService().getPhoneAscription(phone, key)
            }
        }
    }
}