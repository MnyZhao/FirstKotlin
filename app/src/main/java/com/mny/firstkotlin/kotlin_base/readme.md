# kotlin里 不需要分号 
# kotlin 基础  
   - 变量 
   - 函数
   - 类型
## 变量 只读变量(常量)
   * kotlin 如何声明一个变量
     - java 
       - View v;
     - kotlin
       - var v:View (这样会报错-- kotlin 的空安全设计 要求声明变量时必须赋初值)
        - 空安全设计
            - 简单来说就是通过 IDE 的提示来避免调用 null 对象，从而避免 NullPointerException
            - 如果我们需要空变量 那声明方式如下
                - var v:View?=null  在类型后面加一个? 表示可空变量
                  - 在引用该可空变量时要判断是否为空才能进行调用
                    - 有两种方式?. !!.
                      - v?.setBackGroundColor(xxx)
                      - v!!.setBackGroundColor(xxx)
       * 可以看到这里的不同
        - kotlin 有一个var 关键字
        - 类型和变量名称位置互换了
        - 中间是用冒号分隔开
   * kotlin 如何声明一个只读变量 常量
     - java 
       - final int a;
     - kotlin 
       - val a:Int=1
         * 可以看到一点不同
            - final 变成了val
            - 变量名和类型互换了 并用冒号分开
               - val 声明的是只读变量 只允许赋值1次 与java 中的final 类似但是还有一点区别
                 可以重写其getter() 函数 更改其取值
     - kotlin 常量  在val关键字前面加上const关键字 const 只能修饰 val 不能修饰var
         - 在顶层声明 
            - const val cons:Int=10
         - 在object修饰的类中声明，在kotlin中称为对象声明，它相当于Java中一种形式的单例类
            - object{      
               const val cons:Int=10
            -}         
         - 在伴生对象中声明 
             - companion object{
                // kotlin 常量
                const val cons:Int=10
              -}         
## 函数
   * kotlin 如何声明一个函数
     -   fun 函数名称(){} Java 中的 public 在 Kotlin 中可以省略 kotlin的类、函数、变量默认就是公开的
   * kotlin 如何声明一个静态常量 和静态变量 
     - object 修饰的类        
   * 构造函数
     - java 构造函数名称与类名相同
     - kotlin 统一叫做constructor
         . kotlin 还提供了 [ primary constructor 主构造函数] 次级构造函数
         . 写在类中的构造器被称为「次构造器」。在 Kotlin 中一个类最多只能有 1 个主构造器（也可以没有），
         . 而次构造器是没有个数限制。
        * 普通写法
            - class user{
                    var name: String
                    constructor(name: String) {
                        this.name = name
                    }
            - }
        * 主构造写法
            * 注意其中 init 代码块是紧跟在主构造器之后执行的，这是因为主构造器本身没有代码体，
            * init 代码块就充当了主构造器代码体的功能。
            * 另外，如果类中有主构造器，那么其他的次构造器都需要通过 this 关键字调用主构造器，
            * 可以直接调用或者通过别的次构造器间接调用。如果不调用 IDE 就会报错：
          - class user constructor(name: String){
                var name: String
                init{
                    this.name = name
                }
          - }
          * 主构造函数与次构造函数
            具体请看 [Constructor_k.kt] 中的详细描述
            ## 注意 如果使用主构造函数创建对象 那么初始化操作要在init代码块中
            ## 或者直接在声明对象时赋值  因为主构造函数没有函数体 init 就得充当主函数体了
        * 函数简化 可以用 = 号 连接 返回值 
            - 原函数
            fun area(width: Int, height: Int): Int {
                return width * height
            }
            - 简化函数
              只有一行代码的函数，可以这么写：
            fun area(width: Int, height: Int): Int = width * height
              也可以省略返回类型
            fun area(width: Int, height: Int) = width * height
            ## 还是推荐显式地将返回类型写出来，增加代码可读性。
        * 函数支持命名参数并且支持参数默认值且支持可选命名参数
          - fun add(a:Int=10,b:Int) : Int =a+b  参数设置默认值 如果不传递a的值 那就用默认值
             - 调用  add(a=1,b=3) 返回值为1+3=14 命名参数
             - 调用  add(b=5)   返回值为 10+5=15 可选命名参数 使用了a的默认值10 
        * 支持嵌套函数(本地函数) 函数内部嵌套函数 当不想暴露某段逻辑的时候 就可以用
          - fun add(a:Int,b:Int){
                fun sub(){
                    a-b
                }
           }