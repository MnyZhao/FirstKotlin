package com.mny.firstkotlin.kotlin_base.function

/**
 * 函数
 * 表达式
 * {@Link #Standard.kt 内联函数}
 */
class Expression {

    /**
     * 1. 中缀函数
     *  如果一个函数只有一个参数，且用 infix 修饰，那么这个函数就是中缀函数
     *      中缀函数必须是类成员函数或者扩展函数
     *      必须只有一个参数
     *      参数类型不能是可变参数或者默认参数
     */
    infix fun sayHelloTo(name: String) {
        println("Hi $name")
    }
}

/*取出两个集合中共同的元素闭并返回*/
/*扩展函数*/
infix fun <T> List<T>.n(other: List<T>): List<T> {
    val result = ArrayList<T>()
    forEach {
        if (other.contains(it)) {
            result.add(it)
        }
    }
    return result
}

fun main(args: Array<String>) {
    var ex = Expression()
    /*中缀表达式*/
    ex sayHelloTo "Nike"
    var list1 = arrayOf(1, 2, 3, 4, 5, 6)
    var list2 = arrayOf(4, 5, 6, 7, 8, 9, 0)
    var result = list1.toList() n list2.toList()
    result.forEach { println(it) }
}