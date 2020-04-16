package com.mny.firstkotlin.kotlin_smaple04

/**
 * 泛型  out 产出 in 收入
 * 实现一个 fill 函数，传入一个 Array 和一个对象，将对象填充到 Array 中，要求 Array 参数的泛型支持逆变（假设 Array size 为 1）。
 *实现一个 copy 函数，传入两个 Array 参数，将一个 Array 中的元素复制到另外个 Array 中，
 *要求 Array 参数的泛型分别支持协变和逆变。（提示：Kotlin 中的 for 循环如果要用索引，需要使用 Array.indices）
 */
fun main(args: Array<String>) {
    var list: Array<in Int> = arrayOf(1)
    fill(list, 1)
}

fun <T> fill(list: Array<in T>, t: T) {
    list[0] = t
    print(list.get(0))
}

fun <T> copy(from: Array<out T>, to: Array<in T>) {
    for (index in from.indices) {
        to[index] = from[index]
    }
}