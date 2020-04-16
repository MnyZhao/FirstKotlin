package kotlin_base

fun main(args: Array<String>?) {
    //数组
    //声明数组的方式如下
    var iarray: IntArray = intArrayOf(1, 2, 3, 4)
    /**
     * 可以看到 Kotlin 中的数组是一个拥有泛型的类，创建函数也是泛型函数，和集合数据类型一样。
     * 针对泛型的知识点，我们在后面的文章会讲，这里就先按照 Java 泛型来理解。
     * 将数组泛型化有什么好处呢？对数组的操作可以像集合一样功能更强大，由于泛型化，Kotlin 可以给数组增加很多有用的工具函数：
     *      get() / set()
     *      contains()
     *      first()
     *      find()
     *  这样数组的实用性就大大增加了。
     *  取值和修改
     *       Kotlin 中获取或者设置数组元素和 Java 一样，可以使用方括号加下标的方式索引：
     *  不支持协变
     *      Kotlin 的数组编译成字节码时使用的仍然是 Java 的数组，但在语言层面是泛型实现
     *      ，这样会失去协变 (covariance) 特性，就是子类数组对象不能赋值给父类的数组变量：
     *      但是java 子类数组可以赋值给父类对象
     */
    var sarray: Array<String> = arrayOf("1", "2", "3", "4")
    print(sarray[0])
    for (i in iarray) {
        println(i.toString())
    }
    //协变
    /*val strs: Array<String> = arrayOf("a", "b", "c")
    val anys: Array<Any> = strs*/
    // 集合
    /**
     * Kotlin 和 Java 一样有三种集合类型：List、Set 和 Map，它们的含义分别如下：
     *  List 以固定顺序存储一组元素，元素可以重复。
     *  Set 存储一组互不相等的元素，通常没有固定顺序。
     *  Map 存储 键-值 对的数据集合，键互不相等，但不同的键可以对应相同的值。
     *
     *  而且 Kotlin 中的 List 多了一个特性：支持 covariant（协变）。
     *  也就是说，可以把子类的 List 赋值给父类的 List 变量：
     *  Kotlin 中数组和 MutableList 的 API 是非常像的，主要的区别是数组的元素个数不能变。那在什么时候用数组呢？
     *  这个问题在 Java 中就存在了，数组和 List 的功能类似，List 的功能更多一些，直觉上应该用 List 。
     *  但数组也不是没有优势，基本类型 (int[]、float[]) 的数组不用自动装箱，性能好一点。
     *  在 Kotlin 中也是同样的道理，在一些性能需求比较苛刻的场景，并且元素类型是基本类型时，
     *  用数组好一点。不过这里要注意一点，Kotlin 中要用专门的基本类型数组类 (IntArray FloatArray LongArray) 才可以免于装箱。也就是说元素不是基本类型时，相比 Array，用 List 更方便些。
     * 可变集合/不可变集合
     * 上面修改 Map 值的例子中，创建函数用的是 mutableMapOf() 而不是 mapOf()，
     * 因为只有 mutableMapOf() 创建的 Map 才可以修改。Kotlin 中集合分为两种类型：只读的和可变的。这里的只读有两层意思：
     * 集合的 size 不可变
     * 集合中的元素值不可变
     * 以下是三种集合类型创建不可变和可变实例的例子：
     *      listOf() 创建不可变的 List，mutableListOf() 创建可变的 List。
     *      setOf() 创建不可变的 Set，mutableSetOf() 创建可变的 Set。
     *      mapOf() 创建不可变的 Map，mutableMapOf() 创建可变的 Map。
     * 可以看到，有 mutable 前缀的函数创建的是可变的集合，没有 mutbale 前缀的创建的是不可变的集合，
     * 不过不可变的可以通过 toMutable*() 系函数转换成可变的集合：
     * 然后就可以对集合进行修改了，这里有一点需要注意下：
     * toMutable*() 返回的是一个新建的集合，原有的集合还是不可变的，
     * 所以只能对函数返回的集合修改。
     */
    var iList: List<Int> = listOf()// 只读集合
    var iMList: MutableList<Int> = mutableListOf() // 可变集合
    iMList.add(1)
    var map: Map<String, String> = mapOf("1" to "value1")
    //取值方式两种
    println(map.get("1"))
    println(map["1"])
    var mapm = map.toMutableMap()
    mapm.put("2", "key")

    /**
     * Sequence
     * 除了集合 Kotlin 还引入了一个新的容器类型 Sequence ，
     * 它和 Iterable 一样用来遍历一组数据并可以对每个元素进行特定的处理
     * 先来看看如何创建一个 Sequence。
     */
    //创建
    //类似 listOf () ，使用一组元素创建：
    var seq: Sequence<String> = sequenceOf("a", "b", "c")
    // 使用 Iterable 创建：
    val list = listOf("a", "b", "c")
    list.asSequence() // list 实现了Iterable
    //使用 lambda 表达式创建：
    // 👇 第一个元素
    val sequence = generateSequence(0) { it + 1 }
    // 👆 lambda 表达式，负责生成第二个及以后的元素，it 表示前一个元素
    // 我们已经了解了创建方式 下面看看如何应用
    // 序列 Sequence 又被称为「惰性集合操作」
    println("sequence")
    val sequence1 = sequenceOf(1, 2, 3, 4)
    val result: Sequence<Int> = sequence1
        .map { i ->
            println("Map $i")
            i * 2
        }
        .filter { i ->
            println("Filter $i")
            i % 3 == 0
        }
    println(result.first()) // 只取集合的第一个元素
    println("List")
    /**
     * 惰性的概念首先就是说代码运行时不会立即执行，它只是定义了一个执行流程，只有 result 被使用到的时候才会执行
    - 执行时数据处理流程是这样的：
    取出元素 1 -> map 为 2 -> filter 判断 2 是否能被 3 整除
    取出元素 2 -> map 为 4 -> filter 判断 4 是否能被 3 整除
    ...
    - 惰性指当出现满足条件的第一个元素的时候，Sequence 就不会执行后面的元素遍历了，
    即跳过了 元素 4 的遍历。
     */
    //而 List 是没有惰性的特性的：
    val list1 = listOf(1, 2, 3, 4)
    val result1: List<Int> = list1
        .map { i ->
            println("Map $i")
            i * 2
        }
        .filter { i ->
            println("Filter $i")
            i % 3 == 0
        }
    println(result1.first()) // 👈 只取集合的第一个元素
    /**
     *包括两点：
     *   - 声明之后立即执行
     * 数据处理流程如下：
     *   - {1, 2, 3, 4} -> {2, 4, 6, 8}
     *   - 遍历判断是否能被 3 整除
     * Sequence 这种类似懒加载的实现有下面这些优点：
     *   - 一旦满足遍历退出的条件，就可以省略后续不必要的遍历过程。
     *   - 像 List 这种实现 Iterable 接口的集合类，每调用一次函数就会生成一个新的 Iterable，
     *      下一个函数再基于新的 Iterable 执行，
     *      每次函数调用产生的临时 Iterable 会导致额外的内存消耗，而 Sequence 在整个流程中只有一个。
     *   - 因此，Sequence 这种数据类型可以在数据量比较大或者数据量未知的时候，作为流式处理的解决方案。
     */

}