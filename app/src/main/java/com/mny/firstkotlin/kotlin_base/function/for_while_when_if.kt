package com.mny.firstkotlin.kotlin_base.function

fun main(args: Array<String>) {

    // for 循环的多种方式 遍历从1-100
    println("正序")
    for (index in 1..100) {
        print(index.toString())
    }
    println()
    println("倒序")
    // 倒叙用 downTo 函数
    for (index in 100 downTo 1) {
        print(index)
    }
    println()
    println("想不使用1作为遍历的步长，可以使用step()函数：")
    for (index in 1..100 step 2) {
        print(index)////会输出1..3..5......
    }
    println()
    println("倒叙设置步长值")
    for (index in 100 downTo 1 step 2) {
        print(index)
    }
    println()
    println(" 要创建一个不包含末尾元素的区间：")
    for (index in 1 until 10) {
        print(index)//输出1..9
    }
    println()
    println("遍历集合只取元素")
    var iList = listOf<Int>(12, 22, 33, 44, 55)
    for (item in iList) {
        print(item)
    }
    println()
    println("遍历集合只取下标记 - 根据下标取值输出元素")
    for (index in iList.indices) {
        print(index)
        print("-")
        print(iList.get(index))
    }
    println()
    println("遍历集合取下标和元素")
    for ((index, e) in iList.withIndex()) {
        println("下标=$index----元素=$e")
    }
    println()
    println("foreach")
    iList.forEach {
        print(it.toString())
    }
    println()
    println("while do while->与java类似 不能作为表达式")
    var i: Int = 1
    while (i < 100) {
        print(i)
        i++
    }
    println()
    var l: Int = 1
    do {
        print(l)
        l++
    } while (l < 100)
    println()
    println(
        "Kotlin中when语句相当于Java的switch,只不过相对更加的强大，灵活性更好。\n" +
                "kotlin的when可以做传统语句使用\n" +
                "kotlin的when可以做表达式使用\n" +
                "kotlin的when中不需要switch中的case-break·语句直接用->表示一条分支\n" +
                "kotlin的when中每个分支中->后的执行语句大于一条，需要用{}包裹\n" +
                "kotlin的when中多个分支中执行相同语句，用,隔开\n"
    )
    println(testWhen(1))
    println(testWhen("0"))

    println(
        "if Java中if-else语句只能作为普通语句使用，也必须在方法里使用\n" +
                "Kotlin中if-else语句基本用法和java一样，可作为普通语句使用\n" +
                "Kotlin中if-else语句,还可以做为表达式，也不用写在函数式里面"
    )
    println(testIf(1))

}


fun testWhen(i: Int): String {
    // 常规用法
    when (i) {
        0 -> return "Yes"
        1, 2 -> return "ok?"
        else -> return "No"
    }
}

fun testWhen(i: String): String {
    //做表达式用
    return when (i) {
        "0" -> return "YES"
        "1", "2" -> return "ok?"
        else -> return "No"
    }
}

// 作为表达式函数外用法

var pisiton = 10
var name1 = when (pisiton) {
    1 -> "ok"
    else -> "no"
}

fun testIf(i: Int): String {
    //常规用法
    if (i == 10) {
        return "ok"
    } else {
        return "no"
    }
    //表达式用法
    return if (i == 10) "ok" else "no"
}

//作为表达式函数外用法
var if1 = if (10 == 10) "ok" else "no"