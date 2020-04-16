package com.mny.firstkotlin.kotlin_phone_net.net.api.source

object SourceFactory {
    fun getPhoneCommonData(): PhoneSource {
        return PhoneSourceImpl()
    }
}