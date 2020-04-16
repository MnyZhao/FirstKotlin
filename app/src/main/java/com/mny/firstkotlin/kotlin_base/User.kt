package com.mny.firstkotlin.kotlin_base

import kotlin_base.class_person

// 冒号 :  表示继承 不仅可以表示继承，还可以表示 Java 中的 implement
// Kotlin 中可以省略public 修饰可见性 kotlin的类、函数、变量默认就是公开的
open class User : class_person {

    /**
     *  java 中构造器与类名相同
     *  Kotlin 中构造器 统一名称都叫做 constructor
     *  Kotlin 中Java 中的 public 在 Kotlin 中可以省略 kotlin中的类的可见性默认就是公开的
     *  J除了构造器，Java 里常常配合一起使用的 init 代码块 Java {}
     *  在 Kotlin 里的写法也有了一点点改变：你需要给它加一个 init 前缀。 Kotlin  init{}
     */
    constructor() {}

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    /**
     * kotlin 中声明变量
     * var| val 变量名称 [:变量类型] [= 初始值]
     * var variable的缩写  var 声明的是可读可写变量
     * val value 的缩写   val 声明的是只读变量 只允许赋值1次
     * 但是可以重写其get() 函数 更改其取值
     *
     */
    var name: String = "Mike"
        get() {
            return field + "NB"
        }
        set(value) {
            field = value + "set"
        }

    var age: Int? = null
        get() {
            return field
        }
        set(value) {
            field = value;
        };

    /**
     * eat 是可遗传的 我们在这里加了final 关闭其遗传性
     */
    final override fun eat() {
        super.eat()
        object : test {
            override fun tt() {

            }
        }
    }
}
interface test{
    fun tt()
}


