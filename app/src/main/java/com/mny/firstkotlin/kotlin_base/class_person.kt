package kotlin_base

/**
 * 类
 * java 中的Object 表示所有类基类  kotlin 中基类则用Any 表示
 * Kotlin 中Java 中的 public 在 Kotlin 中可以省略 类、函数、变量默认就是公开的
 * Java允许你创建任意类的子类并重写任意方法，除非显式地使用 了 final关键字进行标注
 * java 中的类 和方法 如果不加final 是可以被继承的 被重写的
 * kotlin 中的类 和方法 默认是final 不可被继承的 不可被重写 如果想要被继承 想要被重写
 * 用open 修饰  [open class kitlin{} open fun eat(){}]
 * 如果要想关闭子类中的override 可遗传性 只要加final 修饰即可
 * class User : Person {
 *       constructor() {}
 *       // 我们在这里加了final 关闭其遗传性
 *       final override fun eat() {
 *           super.eat()
 *          }
 *       }
 */
open class class_person {
    /**
     * kotlin 中声明变量
     * var| val 变量名称 [:变量类型] [= 初始值]
     * var variable的缩写  var 声明的是可读可写变量
     * val value 的缩写   val 声明的是只读变量 只允许赋值1次 与java 中的final 类似但是还有一点区别
     * 可以重写其getter() 函数 更改其取值  如下
     * 不过这个属于 val 的另外一种用法，大部分情况下 val 还是对应于 Java 中的 final 使用的
     */
    var personvalue: String = "Mike"
    val person1: Int = 1
        get() {
            //每次返回都会执行+1 操作
            return field + 1;
        }

    open fun eat() = print("eat")
    /**
     * 函数声明用 fun
     * Java 中的 public 在 Kotlin 中可以省略 函数的可见性默认就是公开的
     */
    fun eat1() {
        print("eat1" + person1.toString())
    }

    /**
     * final
     * Kotlin 中的 val 和 Java 中的 final 类似，表示只读变量，不能修改
     * Kotlin 函数参数默认是 val 类型，所以参数前不需要写 val 关键字，
     * Kotlin 里这样设计的原因是保证了参数不会被修改，
     * 而 Java 的参数可修改（默认没 final 修饰）会增加出错的概率。
     */
    val final1: Int = 1

    fun methad(final2: String) {
        val final3 = final2 + final1.toString()
    }
}
