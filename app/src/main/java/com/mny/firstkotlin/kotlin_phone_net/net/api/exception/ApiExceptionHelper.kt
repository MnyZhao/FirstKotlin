package com.mny.firstkotlin.kotlin_phone_net.net.api.exception

import android.content.Context
import android.widget.Toast


class ApiExceptionHelper {
    fun isSuccess(statesCode: String): Boolean {
        return statesCode.equals(ApiStateCode.SUCCESS_CODE)
    }

    /**
     * 服务器自定error
     */
    fun handleApiException(context: Context, e: ApiException) {
        e.errorCode?.let {
            Toast.makeText(
                context,
                "ErrorCode: ${e.errorCode} ErrorMessage: ${e.errorMessage}", Toast.LENGTH_SHORT
            ).show()
            /*根据code 做出不同响应 比如登陆超时返回首页 token 超时直接退出程序*/
//            when(it){
//                ApiStateCode.IP_ERROR
//
//            }
        }
    }

    /**
     * 网络错误 解析错误 404 500 等
     */
    fun handleException(context: Context, e: Exception) {
        Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
    }

}