package kotlin_base

/**
 * 除了静态函数这种简便的调用方式，Kotlin 还有更方便的东西：「top-level declaration 顶层声明」。
 * 其实就是把属性和函数的声明不写在 class 里面，这个在 Kotlin 里是允许的：
 * 这样写的属性和函数，不属于任何 class，而是直接属于 package，
 * 它和静态变量、静态函数一样是全局的，但用起来更方便：你在其它地方用的时候，就连类名都不用写：
 * 写在顶级的函数或者变量有个好处：在 Android Studio 中写代码时，IDE 很容易根据你写的函数前几个字母自动联想出相应的函数。
 * 这样提高了写代码的效率，而且可以减少项目中的重复代码。
 * 命名相同的顶级函数:
 * IDE 会根据包名来区分
 * 对比
 *  那在实际使用中，在 object、companion object 和 top-level 中该选择哪一个呢？
 *  简单来说按照下面这两个原则判断：
 *      如果想写工具类的功能，直接创建文件，写 top-level「顶层」函数。
 *      如果需要继承别的类或者实现接口，就用 object 或 companion object。
 */

var name="jack"
fun add(a: Int, b: Int): Int {
    return a + b;
}

fun sub(a: Int, b: Int): Int {
    return a - b;
}