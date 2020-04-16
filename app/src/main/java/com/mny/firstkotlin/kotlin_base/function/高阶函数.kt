package com.mny.firstkotlin.kotlin_base.function

/**
 * 高阶函数
 *  定义
 *     如果函数参数存在函数 该函数就称为高阶函数
 */
class HigherFunction {

}

fun main() {
    var a = 10
    var b = 2
    Calculation1(a, b, ::sub)

}

fun sub(a: Int, b: Int): Int {
    return a - b
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

/**
 * @param a 传递的第一个数据
 * @param b 传递的第二个数据
 * @param block  工具  对a,b的操作 传递函数的引用(通过:: 双冒号来引用)或者函数
 * @return 工具操作ab的返回值
 */
fun Calculation(a: Int, b: Int, block: (a: Int, b: Int) -> Int): Int {
    return block.invoke(a, b)
}