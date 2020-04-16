package com.mny.firstkotlin.kotlin_smaple02

/**
 * 再看看 Kotlin 中的可见性修饰符，Kotlin 中有四种可见性修饰符：
 *  public：公开，可见性最大，哪里都可以引用。
 *  private：私有，可见性最小，根据声明位置不同可分为类中可见和文件中可见。
 *  protected：保护，相当于 private + 子类可见。
 *  internal：内部，仅对 module 内可见
 */
class Person {
    private constructor()

    companion object {
        var p: Person = Person()
        fun getPersonInstance(): Person {
            return Person()
        }
    }
}