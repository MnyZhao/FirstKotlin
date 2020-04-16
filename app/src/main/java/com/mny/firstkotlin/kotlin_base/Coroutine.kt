package com.mny.firstkotlin.kotlin_base

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlinx.coroutines.*
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.net.URL
import java.net.URLConnection


/**
 * Coroutine  协程
 * 创建协程的方式
 * 如下
 */
fun main(args: Array<String>) {

    runBlocking {
        launch {
            println(Thread.currentThread().name)
        }
    }
    GlobalScope.launch() {
        print(getImage(url).toString());
        println(Thread.currentThread().name)
    }
    CoroutineScope(Dispatchers.IO).launch {
        launch(Dispatchers.Main) {
            println(Thread.currentThread().name)
        }
        async {
            println(Thread.currentThread().name)
        }
    }
}

val url = "http://a3.att.hudong.com/14/75/01300000164186121366756803686.jpg"
fun getImage(url: String): Bitmap? {
//    val url= Url(url)
    val url = URL(url)
    var conn: URLConnection? = null

    try {
        conn = url.openConnection()
    } catch (e1: IOException) { // TODO Auto-generated catch block
        e1.printStackTrace()
    }
    var input: BufferedInputStream? = null
    try {
        input = BufferedInputStream(conn?.getInputStream())
        var stream = ByteArrayOutputStream()
        val bs = ByteArray(1024 * 50)
        var len = -1
        while (input.read(bs).also({ len = it }) != -1) {
            println(len)
            stream.write(bs, 0, len)
        }
        val result: ByteArray = stream.toByteArray()
        stream.close()
        input.close()
        return BitmapFactory.decodeByteArray(result, 0, bs.size)
    } catch (e: IOException) { // TODO Auto-generated catch block
        e.printStackTrace()
    } finally {
        return null
    }
}
