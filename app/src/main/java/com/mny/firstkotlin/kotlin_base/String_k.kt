package kotlin_base

/**
 * 字符串
 *   - 字符串模板
 *      - java 中字符串和变量是用 + 拼接
 *      - kotlin 中也是
 *      - 当变量比较多的时候可读性变差 所以
 *          - java 提供了 String.format("Hi %s", name)
 *          - kotlin 中则更方便 用 '$' 符号加参数的方式
 *              - print("Hi $ name")
 *              - 这种方式就是把 name 从后置改为前置，简化代码的同时增加了字符串的可读性。
 *              - 除了变量，$ 后还可以跟表达式，但表达式是一个整体，所以我们要用 {} 给它包起来：
 *                  - val name = "world"
 *                    println("Hi ${name.length}")
 *              - 字符串模板还支持转义字符，比如使用转义字符 \n 进行换行操作
 *      - 当我们不希望字符被转义  Kotlin 通过「原生字符串」来实现
 *          - 就是用法就是使用一对 """ 将字符串括起来：
 */
fun main(args: Array<String>) {
    val name = "jack"
    println("Hi" + name)  // 输出 Hi jack
    println("Hi $name") // 输出 Hi jack
    println("Hi ${name.length}") // 输出 Hi 4
    println(" Hi \n $name") //会换行
    val name1 = "Mike"
    val msg = """
        |Hi $name !
        |My name is  $name1 .\n
    """
    println(msg) //丛输出结果看 字符串\n 不会被转义为换行符 并且按原格式输出
    println(msg.trimIndent())//  去掉空格输出
    /**
     * 这里的 trimMargin() 函数有以下几个注意点：
     * | 符号为默认的边界前缀，前面只能有空格，否则不会生效
     * 输出时 | 符号以及它前面的空格都会被删除
     * 边界前缀还可以使用其他字符，比如 trimMargin("/")
     * 只不过上方的代码使用的是参数默认值的调用方式
     */
    println(msg.trimMargin("|"))// 输出是
}