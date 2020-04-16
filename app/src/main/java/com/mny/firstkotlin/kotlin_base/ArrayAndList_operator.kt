package com.mny.firstkotlin.kotlin_base

/**
 * 数组和集合的部分操作符
 */
fun main(args: Array<String>) {
    val intArray = intArrayOf(1, 2, 3)
    val strList = listOf("a", "b", "c")
    // 遍历集合元素 方式不止这一种 更多的请看 for_while_when_if.kt
    //lambda 表达式，it 表示数组的每个元素
    intArray.forEach { it -> print(it) }
    intArray.forEach { print(it) }
    //filter：对每个元素进行过滤操作，
    // 如果 lambda 表达式中的条件成立则留下该元素，否则剔除，最终生成新的集合
    println()
    println(
        "filter：对每个元素进行过滤操作，\n" +
                "如果 lambda 表达式中的条件成立则留下该元素，否则剔除，最终生成新的集合"
    )
    val newList:List<Int> = intArray.filter { it != 1 }
    newList.forEach { print(it) } // 输出2 3
    //map：遍历每个元素并执行给定表达式，最终形成新的集合
    println()
    println("map：遍历每个元素并执行给定表达式，最终形成新的集合")
    val new2List:List<Int> = intArray.map { it + 1 }
    new2List.forEach { print(it) } // 输出2 3 4
    //flatMap：遍历每个元素，并为每个元素创建新的集合，最后合并到一个集合中
    println()
    println("flatMap：遍历每个元素，并为每个元素创建新的集合，最后合并到一个集合中 可以对比rxjava的flatmap")
    val new3List = intArray.flatMap { listOf(it + 1, "a") }
    new3List.forEach { print(it) } // 输出 2a3a4a
    var lists= mutableListOf<String>()
    lists.add("!")
}