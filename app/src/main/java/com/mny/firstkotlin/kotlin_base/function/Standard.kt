package com.mny.firstkotlin.kotlin_base.function

/**
 * 标准函数(内联函数) run  apply let  also with
 */
fun main(args: Array<String>) {

    var u = U("nike", 20)
    var u1 = u.run {
        println("run: " + this.name + "-》" + this.age)
        "run"
        return@run 2
    }
    /**
     * 输出结果如下
     * run: nike-》20
     * run
     * 调用某对象的run函数，
     * 在函数块内可以通过 this 指代该对象。返回值为函数块的最后一行或指定return表达式。
     */
    println(u1)
    var u2 = u.apply {
        println("apply: " + this.name + "-》" + this.age)
        "apply"

    }
    println(u2)
    /**
     * 输出结果如下
     * apply: nike-》20
     * com.mny.firstkotlin.kotlin_base.function.U@4b1210ee(对象在内存中的引用地址)
     * 调用某对象的apply函数，在函数块内可以通过 this 指代该对象。返回值为该对象自己。
     */
    var u3 = u.let {
        println("let: " + it.name + "-》" + it.age)
        "let"
        return@let 1
    }
    println(u3)
    /**
     * 输出结果如下
     * let: nike-》20
     * let
     * 调用某对象的let函数，则该对象为函数的参数。(对象在内存中的引用地址)
     * 在函数块内可以通过 it 指代该对象。返回值为函数块的最后一行或指定return表达式。
     */
    var u4 = u.also {
        println("also: " + it.name + "-》" + it.age)
        "also"
    }
    println(u4)
    /**
     * 输出结果如下
     * also: nike-》20
     * com.mny.firstkotlin.kotlin_base.function.U@4b1210ee (对象在内存中的引用地址)
     * 调用某对象的also函数，则该对象为函数的参数。
     * 在函数块内可以通过 it 指代该对象。返回值为该对象自己。
     */
    var u5 = with(u) {
        println("with: " + this.name + "-》" + this.age)
        "with"
        return@with 5
    }
    println(u5)
    /**
     * 输出如下结果  with 返回值为最后一行
     * with: nike-》20
     * with
     * with函数和前面的几个函数使用方式略有不同，因为它不是以扩展的形式存在的。
     * 它是将某对象作为函数的参数，在函数块内可以通过 this 指代该对象。
     * 返回值为函数块的最后一行或指定return表达式。
     */
}

class U(var name: String, var age: Int)

