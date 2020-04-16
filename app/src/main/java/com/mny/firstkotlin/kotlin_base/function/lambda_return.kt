package com.mny.firstkotlin.kotlin_base.function

import okhttp3.internal.indexOf

class Lambda_return {}

/**
 * lambda 表达式返回值为最后一行 不需要return语句
 * 通过() invoke() 调用 返回最后一行
 */
fun main(args: Array<String>) {
    val res = {
        print("Hi")
        10
        "hello"
    }.invoke()
    println(res)

    var s = "jackname"
    /**
     * foreach String的扩展函数 传递一个函数作为参数 
     */
    s.forEach {
        println(it)
    }
    s.forEach(::char)
    s.forEach(::println)
    val array = arrayOf("jack", "walf", "jessica")
    /**
     * indexOfFirst 数组的扩展函数 传递一个函数
     */
    println(array.indexOfFirst { it.startsWith("j") })

}

fun char(char: Char) {
    println(char)
}