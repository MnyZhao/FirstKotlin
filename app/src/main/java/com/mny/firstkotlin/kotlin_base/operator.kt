package com.mny.firstkotlin.kotlin_base

/**
 * 基本操作符
 */
fun main(args: Array<String>) {
    /**
     * ?.  空安全调用 ?.，在对象非空时会执行后面的调用，对象为空时就会返回 null
     * ?:  Elvis 操作符 ?: 当对象为空返回后面的值 否则返回该对象
     */
    val str: String? = "Hello"
    //var length: Int = str?.length
    // ，IDE 报错，报错的原因就是 str 为 null 时我们没有值可以返回给 length
    // 这时候可以用 ?: str 为空时 返回-1
    var length1: Int = str?.length ?: -1
    println("Length1 $length1")
    // 还有种用法
    class User(var id: Int) {}

    fun validate(user: User) {
        val id = user.id ?: return // 👈 验证 user.id 是否为空，为空时 return
    }

    var model: String? = null
    model?.also{
        var a = 3
        var b = 4
        println(model)
    } ?: printss(1, 3)

    model = "1"
//    fun check(){
    var boolean: Boolean = model?.let { false } ?: true
    println("boolean $boolean")
    println(model ?: -1)
//    }
    /**
     * =   ：赋值符号
     * ==  ：可以对基本数据类型以及 String 等类型进行内容比较，相当于 Java 中的 equals
     * === ：对引用的内存地址进行比较，相当于 Java 中的 ==
     */
    val str1 = "123"
    val str2 = "123"
    println(str1 == str2) // 👈 内容相等，输出：true ​
    val str4 = "字符串"
    val str5 = str1
    val str6 = str1
    print(str5 === str6) // 👈 引用地址相等，输出：true
    //其实 Kotlin 中的 equals 函数是 == 的操作符重载，

}

fun printss(a: Int, b: Int) {
    println(a + b)
}