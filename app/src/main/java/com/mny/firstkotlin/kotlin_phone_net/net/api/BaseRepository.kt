package com.mny.firstkotlin.kotlin_phone_net.net.api


import com.blankj.utilcode.util.NetworkUtils
import com.mny.firstkotlin.App
import com.mny.firstkotlin.kotlin_phone_net.net.api.exception.ApiException
import com.mny.firstkotlin.kotlin_phone_net.net.api.exception.ApiExceptionHelper
import com.mny.firstkotlin.kotlin_phone_net.net.model.respmodel.HttpResult
import java.io.IOException


/**
 * 处理返回结果
 */
open class BaseRepository {
    /**
     * 将网络请求函数作为方法传递 请求数据并处理返回结果
     * 处理返回结果IOException错误(解析异常，网络错误等)
     */
    suspend fun <T : Any> safeApiCall(
        call: suspend () -> HttpResult<T>
    ): Result<T> {
        /*处理发送网络请求时产生的异常 多数为IOException或者 httpexception*/
        return try {
            safeApiResult(call)
        } catch (e: Exception) {
            ApiExceptionHelper().handleException(App.context, e)
            Result.Error(e)
//            Result.Error(IOException(e))
        }
    }

    /**
     * 将网络请求函数作为方法传递 请求数据并处理返回结果
     * 处理返回结果api错误 {@link ApiExceptionHelper.kt#isSuccess()}
     * @
     */
    private suspend fun <T : Any> safeApiResult(
        call: suspend () -> HttpResult<T>
    ): Result<T> {
        /*添加无网络判断直接抛出无网络异常*/
        if (!NetworkUtils.isConnected()) {
            var e = IOException("无网络连接")
            ApiExceptionHelper().handleException(App.context, e)
            return Result.NetError(e)
        }
        /*逻辑处理网络请求 处理api异常*/
        val response = call.invoke()
        if (ApiExceptionHelper().isSuccess(response.resultcode)) {
            return Result.Success(response.result)
        } else {
            /*调用ApiExceptionHelper 根据不同code处理不同逻辑*/
            ApiExceptionHelper().handleApiException(
                App.context,
                ApiException(response.resultcode, response.reason)
            )
            return Result.Error(
                ApiException(response.resultcode, response.reason)
            )
        }
    }
}