package com.mny.firstkotlin.kotlin_base

class Person_S {
    /**
     * 静态变量 静态方法
     * Java 中 通过 static 关键字修饰 变量/方法
     * kotlin 中去掉了静态方法和静态变量两个概念
     * 那我们如何通过类名直接引用方法和变量呢
     * 通过 companion object{}
     *
     * 除了静态函数这种简便的调用方式，Kotlin 还有更方便的东西：「top-level declaration 顶层声明」。
     * 其实就是把属性和函数的声明不写在 class 里面，这个在 Kotlin 里是允许的：
     */
    class Person1 {
        companion object{
            /**
             * 静态初始化
             * Java 中的静态变量和方法，在 Kotlin 中都放在了 companion object 中。
             * 因此 Java 中的静态初始化在 Kotlin 中自然也是放在 companion object 中的，
             * 像类的初始化代码一样，由 init 和一对大括号表示：
             */
            init {
            }
            // 常量 用const 标记  编译时常量
            const val pID: Int = 1
            //静态方法
            fun check() {}
        }
    }

    /**
     *  用 object 修饰的对象中的变量和函数都是静态的,但有时候，我们只想让类中的一部分函数和变量是静态的该怎么做呢：
     *      可以在B类中创建一个对象，把需要静态的变量或函数放在内部对象D中，
     *      外界可通过B.D.d 调用
     *      类中嵌套的对象可以用 companion 修饰 这样可以省略对象名称D
     *      外界可以通过B.d 调用
     *  companion 可以理解为伴随、伴生，表示修饰的对象和外部类绑定。
     *      但这里有一个小限制：一个类中最多只可以有一个伴生对象D ，但可以有多个嵌套对象E,F等。就像皇帝后宫佳丽三千，但皇后只有一个。
     *      这样的好处是调用的时候可以省掉对象名：
     *  object 是什么
     *     java 中的Object 表示所有类基类  kotlin 中基类则用Any 表示
     *     kotlin 中的obiect 与class 类似 是关键字
     *     object B{ var id:Int =1}
     *     它的意思很直接：创建一个类，并且创建一个这个类的对象。这个就是 object 的意思：对象
     *     在代码中如果要使用这个对象，直接通过它的类名就可以访问：
     *     B.id
     *  在kotlin 中如何实现单例模式
     *      直接将class 换成object
     * 和 Java 相比的不同点有：
     *      和类的定义类似，但是把 class 换成了 object 。
     *      不需要额外维护一个实例变量 sInstance。
     *      不需要「保证实例只创建一次」的 getInstance() 方法。
     *   相比 Java 的实现简单多了。
     *      这种通过 object 实现的单例是一个饿汉式的单例，并且实现了线程安全。
     * object 可以继承类和实现接口 {@link}
     *        为什么 object 可以实现接口呢？简单来讲 object 其实是把两步合并成了一步
     *        ，既有 class 关键字的功能，又实现了单例，这样就容易理解了。
     * Kotlin 还可以创建 Java 中的匿名类，只是写法上有点不同：
     *        和 Java 创建匿名类的方式很相似，只不过把 new 换成了 object:：
     *        Java 中 new 用来创建一个匿名类的对象
     *        Kotlin 中 object: 也可以用来创建匿名类的对象
     *        这里的 new 和 object: 修饰的都是接口或者抽象类。
     */
    object A : B(), C {
        var pIDo: Int = 2
        fun showP() {}
        override fun showB() {
            super.showB()
        }

        override fun showC() {

        }
    }

    open class B {
        var id:Int =1
        //companion object  D {
        companion object {
            val d: Int = 1;
        }

        //        companion object{}
        object E {}

        object F {}

        open fun showB() {}
    }

    interface C {
        fun showC()
    }

    fun test() {
        Person1.pID
        A.pIDo
        A.showP()
        //实现匿名类
        val c: C = object : Person_S.C {
            override fun showC() {
                print("object 实现匿名类")
            }
        }
    }
}