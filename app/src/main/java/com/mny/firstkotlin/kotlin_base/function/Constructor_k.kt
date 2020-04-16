package com.mny.firstkotlin.kotlin_base.function


/**
 * Kotlin 中的构造函数 与java 不同
 * java 中的构造函数与类名相同
 * kotlin 中统一叫constructor
 *
 *     kotlin 还提供了 [ primary constructor 主构造函数] 次级构造函数
 *     写在类中的构造器被称为「次构造器」。在 Kotlin 中一个类最多只能有 1 个主构造器（也可以没有），
 *     而次构造器是没有个数限制。
 */
//我们之前已经了解了 Kotlin 中 constructor 的写法：
class Cons {
    var name: String

    constructor(name: String) {
        this.name = name
    }
}

// Kotlin 中还有更简单的方法来写构造器
class Cons1 constructor(name: String) {
    //                  👇 这里与构造器中的 name 是同一个
    var name: String = name
}

//kotlin 还有比上面更简洁的方法
//主构造器里声明属性
//上面是主构造器中的参数可以在属性中进行赋值，其实还可以在主构造器中直接声明属性：
//          如果在主构造器的参数声明时加上 var 或者 val，
//          就等价于在类中创建了该名称的属性（property），并且初始值就是主构造器中该参数的值。
//          赋值代码都可以省略
class Cons1_1 constructor(var name: String) {
}

/**这里有几处不同点：
 *      constructor 构造器移到了类名之后
 *      类的属性 name 可以引用构造器中的参数 name
 *      这个写法叫「主构造器 primary constructor」。与之相对的在第二篇中，写在类中的构造器被称为「次构造器」。
 *      在 Kotlin 中一个类最多只能有 1 个主构造器（也可以没有），而次构造器是没有个数限制。
 *      主构造器中的参数除了可以在类的属性中使用，还可以在 init 代码块中使用：
 */
class Cons2 constructor(name: String) {
    var name: String

    init {
        this.name = name
    }
}

/**
 * 其中 init 代码块是紧跟在主构造器之后执行的，这是因为主构造器本身没有代码体，
 *      init 代码块就充当了主构造器代码体的功能。
 *      另外，如果类中有主构造器，那么其他的次构造器都需要通过 this 关键字调用主构造器，
 *      可以直接调用或者通过别的次构造器间接调用。如果不调用 IDE 就会报错：
 */
class Cons3 constructor(var name: String) {
    //    constructor(name: String, id: Int) {
    // 👆这样写会报错，Primary constructor call expected
//    }
    var id: Int? = null

    constructor(name: String, id: Int) : this(name) {
        this.id = id
    }
}

/**
 *  为什么当类中有主构造器的时候就强制要求次构造器调用主构造器呢？
 *  我们从主构造器的特性出发，一旦在类中声明了主构造器，就包含两点：
 *      必须性：创建类的对象时，不管使用哪个构造器，都需要主构造器的参与
 *      第一性：在类的初始化过程中，首先执行的就是主构造器
 *      这也就是主构造器的命名由来。
 * 当一个类中同时有主构造器与次构造器的时候，需要这样写：
 */
class Cons4 constructor(var name: String) {
    var id: Int? = null

    //                                  👇  👇 直接调用主构造器
    constructor(name: String, id: Int) : this(name) {
        this.id = id
    }

    var age: Int? = null

    //                                      👇 通过上一个次构造器，间接调用主构造器
    constructor(name: String, id: Int, age: Int) : this(name, id) {
        this.age = age
    }
}

/**
 * 在使用次构造器创建对象时，init 代码块是先于次构造器执行的。
 * 如果把主构造器看成身体的头部，那么 init 代码块就是颈部，次构造器就相当于身体其余部分。
 */
/**
 * 通常情况下，主构造器中的 constructor 关键字可以省略：
 */
class Cons5(var name: String, var id: Int) {
}

//上述写法等价于
class Cons5_1 constructor(var name: String, var id: Int) {}

/**
 * 但有些场景，constructor 是不可以省略的，例如在主构造器上使用「可见性修饰符」或者「注解」l
 */
class Cons6 private constructor(var name: String, var id: Int) {}

/**
 * 当一个类有多个构造器时，只需要把最基本、最通用的那个写成主构造器就行了。
 * 这里我们选择将参数为 name 与 id 的构造器作为主构造器。
 */
class Cons7(var name: String, var id: Int) {
    var age: Int? = null

    constructor(name: String, id: Int, age: Int) : this(name, id) {
        this.age = age
    }
}

/**
 * 注意 如果使用主构造函数创建对象 那么初始化操作要在init代码块中执行
 * 或者直接在声明对象时赋值  因为 主构造函数没有函数体
 */
class Cons8(name: String) {
    var name: String=name

    //    print(name) 因为不能有函数体 所以此处会error
    init {
        this.name = name
    }
}

/**
 * 函数简写 用= 号来
 * 函数支持命名参数并且支持参数默认值且支持可选命名参数
 */
fun a(a: Int = 1, b: Int): Int = a + b

/**
 * 与命名参数相对的一个概念被称为「位置参数」，也就是按位置顺序进行参数填写。
 * 当参数都是命名参数则位置任意 只要标记参数与对应的值
 * 当一个函数被调用时，如果混用位置参数与命名参数，那么所有的位置参数都应该放在第一个命名参数之前：
 */
fun b(a: Int, b: Int, c: String) = print((a + b).toString() + c)

fun main(args: Array<String>) {
    var c = Cons7("javk", 1, 2)
    print(a(b = 2))
    b(
        c = "hello",
        b = 2,
        a = 1
    )//当参数都是命名参数则位置任意 只要标记参数与对应的值
    b(
        1,
        2,
        c = "hello"
    )//如果混用位置参数与命名参数，那么所有的位置参数都应该放在第一个命名参数之前
}
