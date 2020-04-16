package com.mny.firstkotlin

import android.app.Application
import android.content.Context
import com.blankj.utilcode.util.Utils
import kotlin.properties.Delegates

class App : Application() {
        companion object{
        var context:Context by Delegates.notNull()
    }
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        Utils.init(this)
    }
}