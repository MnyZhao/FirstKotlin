package kotlin_base

/**
 * Kotlin 中的 Range 表示区间的意思，也就是范围。
 */
fun main(args: Array<String>) {
    //    区间的常见写法如下 表示1-100
    val range: IntRange = 1..1000
    //这里的 0..1000 就表示从 0 到 1000 的范围，包括 1000，数学上称为闭区间 [0, 1000]。
    // 除了这里的 IntRange ，还有 CharRange 以及 LongRange。
    //Kotlin 中没有纯的开区间的定义，不过有半开区间的定义：
    val range1: IntRange = 0 until 1000
    //这里的 0 until 1000 表示从 0 到 1000，但不包括 1000，这就是半开区间 [0, 1000) 。
    //Range 这个东西，天生就是用来遍历的：
    val range2: IntRange = 0..1000
    for (it in range2) {
        print(it) // 输出0-1000
    }
    println()
    // 除了默认步长值为1 还可以通过step 设置步长值
    for (it in range2 step 2) {
        print(it) // 输出 0 2 4 6 8...1000
    }
    println()
    // Kotlin 还提供了递减区间 downTo ，不过递减没有半开区间的用法:
    for (it in 4 downTo 1 step 2) {
        print(it)
    }
    //这里的 in 关键字可以与 for 循环结合使用，表示挨个遍历 range 中的值。
    // in 关键字结合for 循环还可以遍历 集合
    val list = listOf<Int>(1, 2, 3)
    println()
    for (it in list) {
        println(it) // 输出1 2 3
    }
}