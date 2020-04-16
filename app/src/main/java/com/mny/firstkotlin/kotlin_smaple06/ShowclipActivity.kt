package com.mny.firstkotlin.kotlin_smaple06

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mny.firstkotlin.R
import kotlinx.android.synthetic.main.activity_showclip.*
import kotlinx.coroutines.*
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.net.URL
import java.net.URLConnection

class ShowclipActivity : AppCompatActivity() {
    lateinit var progress: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showclip)
        var coroutineScope = CoroutineScope(Dispatchers.Main)
        coroutineScope.launch {
//                        Intent(this@ShowclipActivity,ShowImageActivity::class.java)

            progress = ProgressDialog.show(this@ShowclipActivity, "Tip", "Loading")
            iv_c_all.setImageBitmap(withContext(Dispatchers.IO) {
                Thread.sleep(3 * 1000)
                getImage(url)
            })
            progress.dismiss()
        }

        coroutineScope.launch {
            iv_c_1.setImageBitmap(clip4get1(url))
            iv_c_2.setImageBitmap(clip9get9(url))
        }
        coroutineScope.launch {
            var b1 = async(Dispatchers.IO) { getClip4(url) }
            var b2 = async(Dispatchers.IO) { getClip9(url) }
            iv_c_1.setImageBitmap(b1.await())
            iv_c_2.setImageBitmap(b2.await())

        }
    }
}

suspend fun clip4get1(url: String): Bitmap? {
    return withContext(Dispatchers.IO) {
        getClip4(url)
    }
}

suspend fun clip9get9(url: String): Bitmap? {
    return withContext(Dispatchers.IO) {
        getClip9(url)
    }
}

fun getClip4(url: String): Bitmap {
    var b = getImage(url)
    var w = (b?.width ?: 0) / 2
    var h = (b?.height ?: 0) / 2
    return Bitmap.createBitmap(b, 0, 0, w, h)
}

fun getClip9(url: String): Bitmap {
    var b = getImage(url)
    var w = (b?.width ?: 0) / 3
    var h = (b?.height ?: 0) / 3
    return Bitmap.createBitmap(b, w * 2, h * 2, w, h)
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
            stream.write(bs, 0, len)
        }
        val result: ByteArray = stream.toByteArray()
        stream.close()
        input.close()
        return BitmapFactory.decodeByteArray(result, 0, result.size)
    } catch (e: IOException) { // TODO Auto-generated catch block
        e.printStackTrace()
        return null
    }
}