package com.mny.firstkotlin.kotlin_smaple02

fun main(args: Array<String>) {
    //创建一个 Kotlin 类，这个类需要禁止外部通过构造器创建实例，并提供至少一种实例化方式。
    //通过静态变量 静态方法
    var p: Person = Person.p
    var p1: Person = Person.getPersonInstance()
    //分别用 Array、IntArray、List 实现 「保存 1-100_000 的数字，并求出这些数字的平均值」
    // ，打印出这三种数据结构的执行时间
    array()
    intArray()
    list()
}

fun array() {
    var timeStart = System.currentTimeMillis()
    var array: Array<Int> = Array<Int>(100, init = { it + 1 })
    var i: Int = 0;
    for (it in array) {
        i += it
    }
    println((i / 100).toString())
    var f:Float=(System.currentTimeMillis() - timeStart)/1000f
    println("f_time/s--"+f)
}

fun intArray() {
    var timeStart = System.currentTimeMillis()
    var array = IntArray(100)
    var i: Int = 1;
    while (i < 101) {
        array[i - 1] = i
        i++
    }
    var l: Int = 0;
    for (it in array) {
        l += it
    }
    println((l / 100).toString())
    var f:Float=(System.currentTimeMillis() - timeStart)/1000f
    println("f_time/s--"+f)
}

fun list() {
    var timeStart = System.currentTimeMillis()
    var list: List<Int> = List<Int>(100, init = { it + 1 })
    var l: Int = 0;
    for (it in list) {
        l += it
    }
    println((l / 100).toString())
    var f:Float=(System.currentTimeMillis() - timeStart)/1000f
    println("f_time/s--"+f)
}