package com.mny.firstkotlin.kotlin_base.function

/**
 * 一般情况下高阶函数和lambda表达式成对出现
 * lambda 也可以单独存在
 */
class lambdaEx {

}

fun main(args: Array<String>) {
    var a = 10
    var b = 2
    { a: Int, b: Int ->
        print(a + b)
    }(1, 2)
    Calculation1(a, b, ::sub1)
    println(Calculation(a, b) { a, b ->
        a * b
    })
    //如果我不想让其他地方调用sub1 那就应该直接传递一个函数进去
    //------------------c,f 就是函数参数 c-f 就是函数操作
    //-----------------如果最后一个参数是lambda表达式(匿名函数) 函数体可以拿到括号外面
    Calculation1(a, b, { c, f -> c - f })// 可以在()中包裹
    Calculation1(a, b) { c, f -> c - f };//也可以将函数体单独提出到外面 如果()中没参数 ()可以省略
    //无参数lambda表达式 { 函数体}.() 调用 或.invoke()调用  invoke 可以控制可空
    {
        println("Hi")
    }();
    //带参数lambda表达式 通过(a,b) 或者invoke(a,b)调用 invoke 可以控制可空
    { a: Int, b: Int ->
        println(a + b)
    }.invoke(10, 20)
    //上述方式只能调用一次 如果想多次调用可以通过变量保存lambda表达式
    val block: () -> Unit = {
        println("Hi")
    };
    println(block)
    val block1 = { a: Int, b: Int ->
        println(a + b)
    }
    println(block1.invoke(1, 2))
}

/**
 * @param a 传递的第一个数据
 * @param b 传递的第二个数据
 * @param block  工具  对a,b的操作 传递函数的引用(通过:: 双冒号来引用)或者函数
 * @return 工具操作ab的返回值
 */
fun Calculation1(a: Int, b: Int, block: (a: Int, b: Int) -> Int): Int {
    return block.invoke(a, b)
}

fun sub1(a: Int, b: Int): Int {
    return a - b
}

fun Caluation(a: Int, b: Int, block: (a: Int, b: Int) -> Int): Int {
    return block.invoke(a, b)
}