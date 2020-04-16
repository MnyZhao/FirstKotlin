package com.mny.firstkotlin.kotlin_smaple05

import CoroutineScopeActivity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mny.firstkotlin.R
import kotlinx.android.synthetic.main.activity_show_image.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.net.URL
import java.net.URLConnection

class ShowImageActivity : CoroutineScopeActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_image)
        launch {
            iv.setImageBitmap(withContext(Dispatchers.IO) {
                getImage(url)
            })
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
}
