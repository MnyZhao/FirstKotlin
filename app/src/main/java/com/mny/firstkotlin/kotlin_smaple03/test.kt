package com.mny.firstkotlin.kotlin_smaple03

/**
 * 请按照以下要求实现一个 Student 类：
 *   - 写出三个构造器，其中一个必须是主构造器
 *  - 主构造器中的参数作为属性
 *  - 写一个普通函数 show，要求通过字符串模板输出类中的属性
 * 编写程序，使用今天所讲的操作符，找出集合 {21, 40, 11, 33, 78} 中能够被 3 整除的所有元素，并输出。
 */
fun main(args: Array<String>) {
    Student("Mike", 1, 20).show()
    val list = listOf<Int>(21, 40, 11, 33, 78)
    var newList = list.filter { it % 3 == 0 }
    newList.forEach { println(it) }
    methad { f("jack") }
    methad { println("name") }
    //lambda 闭包写在函数体外部， 形参中的最后一个形参是函数参数  可以这么写
    action(2) {
        println("函数 回调 -- 第1种传递写法")
    }

    //lambda 闭包作为形参
    action(1, {
        println("函数 回调 -- 第2种传递写法")
    })


    //一步步的 显示调用方式
    var method: () -> Unit = {
        println("函数 回调 -- 第3种传递写法")
    }
    action(3, method)
}

/**
 * 函数作为 形参
 */
fun action(first: Int, callback: () -> Unit) {

    //调用
    callback()
}

fun f(name: String) {
    println(name)
}

fun methad(f: () -> Unit) {
    f.invoke()
}


class Student(var name: String) {
    var id: Int? = null

    constructor(name: String, id: Int) : this(name) {
        this.id = id
    }

    var age: Int? = null

    constructor(name: String, id: Int, age: Int) : this(name, id) {
        this.age = age
    }

    fun show() {
        println("My name is $name \n My Id is $id \n My age is $age")
    }
}