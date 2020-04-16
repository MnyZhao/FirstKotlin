package com.mny.firstkotlin.kotlin_base.function

/**
 * 扩展函数
 * 不改变已有类的基础上为类添加函数
 * 扩展函数可以通过this访问当前对象里的方法和字段
 * 子类可以直接访问父类扩展函数 但是不能进行重写
 */
class Spread_Function {

}

fun main(args: Array<String>) {
    var msg: String? = ""
    println(msg?.myIsEmpty())
    var s = sun()
    s.Hi("Father")
}

/**
 * 1 为String 类添 判断是否为空的函数 myIsEmpty
 * 2 扩展函数可以通过this访问当前对象里的方法和字段
 */
fun String?.myIsEmpty(): Boolean {
    return null == this || this.length == 0
}

fun Father.Hi(name: String) = println("hi $name")
open class Father {

}

class sun : Father() {

}
