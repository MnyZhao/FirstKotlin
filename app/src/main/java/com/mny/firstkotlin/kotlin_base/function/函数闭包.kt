package com.mny.firstkotlin.kotlin_base.function

class Clourse {
}

/**
 * 函数闭包
 * 定义：一个函数返回了一个内部函数，该内部函数引用了外部函数相关参数和变量
 * 我们把该返回的内部函数称为闭包
 * lambda 表达式 函数式编程 函数可以作为返回值
 *  也可以作为参数
 *  闭包让函数可以携带状态。
 */
fun test(): () -> Unit {
    var a = 10 //状态
    return {
        println(a)
        a++
    }
}

fun main(args: Array<String>) {
    test().invoke()// 输出10
    test().invoke()// 输出10
    test().invoke()// 输出10
    var result = test()
    result.invoke()// 输出10
    result.invoke()// 输出11
    result.invoke()// 输出12
    //这里的闭包保存函数 并不是每次调用的新的test方法
    //而是调用的test方法内部返回的函数体 我们叫他b
    // 对于b 来讲 内部执行变量a的输出 并a++
    // 这个test方法对b来讲是外部方法 a就是外部变量
    // 我们调用多次b 改变a的值 那方法外部变量的值自然是会被记录的了
    //
}