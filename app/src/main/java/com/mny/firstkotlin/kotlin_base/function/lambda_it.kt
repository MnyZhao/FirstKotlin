package com.mny.firstkotlin.kotlin_base.function

import com.mny.firstkotlin.kotlin_smaple03.methad

/**
 * lambda 表达式使用的时候 如果只有一个参数 可以省略参数名
 * 默认通过it 来调用
 */
class lambdaIt {

}

fun main(args: Array<String>) {

    //---------------------此处的it 就是下面block函数的参数
    println(methad(10, { it -> it + 1 }))
    println(methad(10, { it + 1 }))//参数为一个的时候可以直接写it 简化写法
    println(methad(10, ::add))
}

/**
 * @param a 参数
 * @param block 参数为Int的一个函数
 */
fun methad(a: Int, block: (Int) -> Int): Int {
    return block.invoke(a)
}

fun add(a: Int): Int {
    return a + 1
}
