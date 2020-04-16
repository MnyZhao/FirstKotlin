package com.mny.firstkotlin.kotlin_base

/**
 * User 后面的() 这其实也是一种省略的写法
 * 等价于 kotlin   class User1 constructor(): User(){}
 * 更像java的写法就如下
 * class User1 :User{
 *   constructor(){}
 * }
 */
class User1 : User() {

    // 会产生error 因为user 中已经关闭了 eat的可遗传性
    /*override fun eat() {
        super.eat()
    }*/
}