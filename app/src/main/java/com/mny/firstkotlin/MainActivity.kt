package com.mny.firstkotlin

import CoroutineScopeActivity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mny.firstkotlin.kotlin_phone_net.CheckPhoneActivity
import com.mny.firstkotlin.kotlin_smaple05.ShowImageActivity
import com.mny.firstkotlin.kotlin_smaple06.ShowclipActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.net.URL
import java.net.URLConnection

class MainActivity :CoroutineScopeActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity, ShowImageActivity::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity, ShowclipActivity::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity, CheckPhoneActivity::class.java)
            startActivity(intent)
        }
    }
}
