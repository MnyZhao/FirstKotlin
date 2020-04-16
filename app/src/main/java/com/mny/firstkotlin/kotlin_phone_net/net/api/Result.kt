package com.mny.firstkotlin.kotlin_phone_net.net.api

/**
 * 构建密封 Result 类
 * 这是用来处理网络响应的类。它可能成功返回所需的数据，也可能发生异常而出错。
 * 这里只添加了三个
 * 如果要添加其他的异常处理 在这里添加即可
 *  比如 空数据异常(DataNullError 一般用来展示无数据界面)
 *       无网络异常(NetError 一般用来显示无网络连接界面)
 *
 */
sealed class Result<out T : Any> {
    // 成功
    data class Success<out T : Any>(val data: T) : Result<T>()

    //失败
    data class Error(val exception: Exception) : Result<Nothing>()

    //失败 无网络连接
    data class NetError(val exception: Exception) : Result<Nothing>()


}