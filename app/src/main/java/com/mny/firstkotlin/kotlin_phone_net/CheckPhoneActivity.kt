package com.mny.firstkotlin.kotlin_phone_net

import CoroutineActivity
import android.os.Bundle
import android.view.View
import com.mny.firstkotlin.R
import com.mny.firstkotlin.kotlin_phone_net.net.api.Result
import com.mny.firstkotlin.kotlin_phone_net.net.api.exception.ApiException
import com.mny.firstkotlin.kotlin_phone_net.net.api.source.SourceFactory
import kotlinx.android.synthetic.main.activity_check_phone.*
import kotlinx.coroutines.launch

class CheckPhoneActivity : CoroutineActivity() {

    val key = "c4a733d52ab7c9b8e121348d85054ecf"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_phone)
        btn_query.setOnClickListener {
            launch {
                pb.visibility = View.VISIBLE
                var result = SourceFactory.getPhoneCommonData()
                    .getPhoneAscription(et_phone.text.toString(), key)
                when (result) {
                    is Result.Success -> {
                        result.data
                        pb.visibility = View.GONE
                        tv_msg.setText(result.toString())
                    }
                    is Result.Error -> {
                        pb.visibility = View.GONE
                        tv_msg.setText(
                            (result.exception.toString() as? ApiException)?.errorMessage
                                ?: result.exception.message
                        )
                    }
                    is Result.NetError -> {
                        pb.visibility = View.GONE
                        tv_msg.setText(
                            (result.exception.toString() as? ApiException)?.errorMessage
                                ?: result.exception.message
                        )
                    }

                }
            }
        }
    }
}
