package com.mny.firstkotlin;


import java.util.ArrayList;
import java.util.List;


/**
 * 泛型，即“参数化类型”。一提到参数，最熟悉的就是定义方法时有形参，然后调用此方法时传递实参。
 * 那么参数化类型怎么理解呢？顾名思义，就是将类型由原来的具体的类型参数化，类似于方法中的变量参数，
 * 此时类型也定义成参数形式（可以称之为类型形参），然后在使用/调用时传入具体的类型（类型实参）。
 * <p>
 * 泛型的本质是为了参数化类型（在不创建新的类型的情况下，通过泛型指定的不同类型来控制形参具
 * 体限制的类型）。也就是说在泛型使用过程中，操作的数据类型被指定为一个参数，
 * 这种参数类型可以用在类、接口和方法中，分别被称为泛型类、泛型接口、泛型方法。
 * <p>
 * 通配符 {@link #showKeyValue1(Generic)}
 */
public class Class_t {
    public static void main(String[] args) {
        check_T();
    }

    /**
     * 泛型类测试
     * 注意
     * 泛型的类型参数只能是类类型，不能是简单类型。
     * 不能对确切的泛型类型使用instanceof操作。如下面的操作是非法的，编译时会出错。
     */
    public static void check_T() {
        //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> genericInteger = new Generic<Integer>(123456);

        //传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic<String> genericString = new Generic<String>("key_vlaue");
        System.out.println("泛型测试" + "key is " + genericInteger.getKey());
        System.out.println("泛型测试" + "key is " + genericString.getKey());
        // 定义的泛型类，就一定要传入泛型类型实参么？ 不一定
        // 并不是这样，在使用泛型的时候如果传入泛型实参，则会根据传入的泛型实参做相应的限制，
        // 此时泛型才会起到本应起到的限制作用。
        // 如果不传入泛型类型实参的话，在泛型类中使用泛型的方法或成员变量定义的类型可以为任何的类型。
        Generic generic = new Generic("111111");
        Generic generic1 = new Generic(4444);
        Generic generic2 = new Generic(55.55);
        Generic generic3 = new Generic(false);

        System.out.println("泛型测试" + "key is " + generic.getKey());
        System.out.println("泛型测试" + "key is " + generic1.getKey());
        System.out.println("泛型测试" + "key is " + generic2.getKey());
        System.out.println("泛型测试" + "key is " + generic3.getKey());
    }

    /**
     * 通配符测试
     */
    public static void testGeneric() {
        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);
        showKeyValue(gNumber);
        // showKeyValue这个方法编译器会为我们报错：Generic<java.lang.Integer>
        // cannot be applied to Generic<java.lang.Number>
        // showKeyValue(gInteger);
        /**
         * 通过提示信息我们可以看到Generic<Integer>不能被看作为`Generic<Number>的子类。由此可以看出:
         *             同一种泛型可以对应多个版本（因为参数类型是不确定的），不同版本的泛型类实例是不兼容的。
         *
         * 回到上面的例子，如何解决上面的问题？总不能为了定义一个新的方法来处理Generic<Integer>类型的类，
         * 这显然与java中的多台理念相违背。
         * 因此我们需要一个在逻辑上可以表示同时是Generic<Integer>和Generic<Number>父类的引用类型。
         * 由此类型通配符应运而生。{@link #showKeyValue1(Generic)}
         */
    }

    public static void showKeyValue(Generic<Number> obj) {
        System.out.println("泛型测试" + "key value is " + obj.getKey());
    }

    /**
     * 类型通配符一般是使用？代替具体的类型实参，注意了，此处’？’是类型实参，而不是类型形参 。
     * 重要说三遍！此处’？’是类型实参，而不是类型形参 ！ 此处’？’是类型实参，而不是类型形参
     * 再直白点的意思就是，此处的？和Number、String、Integer一样都是一种实际的类型，可以把？看成所有类型的父类。是一种真实的类型。
     * <p>
     * 可以解决当具体类型不确定的时候，这个通配符就是 ?  ；当操作类型时，
     * 不需要使用类型的具体功能时，只使用Object类中的功能。那么可以用 ? 通配符来表未知类型。
     */
    public static void showKeyValue1(Generic<?> obj) {
        System.out.println("泛型测试" + "key value is " + obj.getKey());
    }

    /**
     * 泛型方法测试
     */
    public static void testMethad() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object obj = genericMethod(Class.forName("com.test.test"));
    }

    /**
     * 泛型方法的基本介绍
     *
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     * 1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     * 2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     * 3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     * 4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public static <T> T genericMethod(Class<T> tClass) throws InstantiationException,
            IllegalAccessException {
        T instance = tClass.newInstance();
        return instance;
    }
}

/**
 * 1.1 泛型类
 * 泛型类，是在实例化类的时候指明泛型的具体类型；
 * 此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
 * 在实例化泛型类时，必须指定T的具体类型
 *
 * @param <T>
 */

class Generic<T> {
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey() { //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }
}

/**
 * 2.1 泛型接口
 * 泛型接口与泛型类的定义及使用基本相同。泛型接口常被用在各种类的生产器中，如下
 */
interface IGeneric<T> {
    // 返回类型可以是泛型 参数类型也可以是泛型
    T next(T value);
}
// 泛型接口应用

/**
 * 2.3 实现泛型接口一定要传入泛型实参吗？ 不是
 * ------ 当实现泛型接口的类，未传入泛型实参时：
 * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
 * 即：class FruitGenerator<T> implements Generator<T>{
 * 如果不声明泛型，如：class FruitGenerator implements Generator<T>，编译器会报错："Unknown class"
 */
class FruitGenerator<T> implements IGeneric<T> {
    @Override
    public T next(T value) {
        return value;
    }
}

/**
 * 2.3 传入泛型实参时：
 * 定义一个生产器实现这个接口,虽然我们只创建了一个泛型接口Generator<T>
 * 但是我们可以为T传入无数个实参，形成无数种类型的Generator接口。
 * 在实现类实现泛型接口时，如已将泛型类型传入实参类型，则所有使用泛型的地方都要替换成传入的实参类型
 * 即：Generator<T>，public T next();中的的T都要替换成传入的String类型。
 */
class FruitGenerator1 implements IGeneric<String> {
    @Override
    public String next(String value) {
        return value;
    }
}

/**
 * 3.1 泛型方法介绍(当前界面搜索泛型方法介绍) 3.2基本应用
 */
class GenericTest {
    //这个类是个泛型类，在上面已经介绍过
    public class Generic<T> {
        private T key;

        public Generic(T key) {
            this.key = key;
        }

        //我想说的其实是这个，虽然在方法中使用了泛型，但是这并不是一个泛型方法。
        //这只是类中一个普通的成员方法，只不过他的返回值是在声明泛型类已经声明过的泛型。
        //所以在这个方法中才可以继续使用 T 这个泛型。
        public T getKey() {
            return key;
        }

        /**
         * 这个方法显然是有问题的，在编译器会给我们提示这样的错误信息"cannot reslove symbol E"
         * 因为在类的声明中并未声明泛型E，所以在使用E做形参和返回值类型时，编译器会无法识别。
         public E setKey(E key){
         this.key = keu
         }
         */
    }

    /**
     * 这才是一个真正的泛型方法。
     * 首先在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
     * 这个T可以出现在这个泛型方法的任意位置.
     * 泛型的数量也可以为任意多个
     * 如：public <T,K> K showKeyName(Generic<T> container){
     * ...
     * }
     */
    public <T> T showKeyName(Generic<T> container) {
        System.out.println("container key :" + container.getKey());
        //当然这个例子举的不太合适，只是为了说明泛型方法的特性。
        T test = container.getKey();
        return test;
    }

    //这也不是一个泛型方法，这就是一个普通的方法，只是使用了Generic<Number>这个泛型类做形参而已。
    public void showKeyValue1(Generic<Number> obj) {
        System.out.println("泛型测试" + "key value is " + obj.getKey());
    }

    //这也不是一个泛型方法，这也是一个普通的方法，只不过使用了泛型通配符?
    //同时这也印证了泛型通配符章节所描述的，?是一种类型实参，可以看做为Number等所有类的父类
    public void showKeyValue2(Generic<?> obj) {
        System.out.println("泛型测试" + "key value is " + obj.getKey());
    }

    /**
     * 这个方法是有问题的，编译器会为我们提示错误信息："UnKnown class 'E' "
     * 虽然我们声明了<T>,也表明了这是一个可以处理泛型的类型的泛型方法。
     * 但是只声明了泛型类型T，并未声明泛型类型E，因此编译器并不知道该如何处理E这个类型。
     public <T> T showKeyName(Generic<E> container){
     ...
     }
     */

    /**
     * 这个方法也是有问题的，编译器会为我们提示错误信息："UnKnown class 'T' "
     * 对于编译器来说T这个类型并未项目中声明过，因此编译也不知道该如何编译这个类。
     * 所以这也不是一个正确的泛型方法声明。
     * public void showkey(T genericObj){
     * <p>
     * }
     */
}

/**
 * 3.3 类中的泛型方法
 * 当然这并不是泛型方法的全部，泛型方法可以出现杂任何地方和任何场景中使用。
 * 但是有一种情况是非常特殊的，当泛型方法出现在泛型类中时，我们再通过一个例子看一下
 */
class GenericFruit {
    static class Fruit {
        @Override
        public String toString() {
            return "fruit";
        }
    }

    static class Apple extends Fruit {
        @Override
        public String toString() {
            return "apple";
        }
    }

    static class Person {
        @Override
        public String toString() {
            return "Person";
        }
    }

    static class GenerateTest<T> {
        public void show_1(T t) {
            System.out.println(t.toString());
        }

        //在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。可以类型与T相同，也可以不同。
        //由于泛型方法在声明的时候会声明泛型<E>，因此即使在泛型类中并未声明泛型，编译器也能够正确识别泛型方法中识别的泛型。
        public <E> void show_3(E t) {
            System.out.println(t.toString());
        }

        //在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型。
        public <T> void show_2(T t) {
            System.out.println(t.toString());
        }
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        Person person = new Person();

        GenerateTest<Fruit> generateTest = new GenerateTest<Fruit>();
        //apple是Fruit的子类，所以这里可以
        generateTest.show_1(apple);
        //编译器会报错，因为泛型类型实参指定的是Fruit，而传入的实参类是Person
        //generateTest.show_1(person);

        //使用这两个方法都可以成功
        generateTest.show_2(apple);
        generateTest.show_2(person);

        //使用这两个方法也都可以成功
        generateTest.show_3(apple);
        generateTest.show_3(person);
    }
}

/**
 * 3.4 静态方法与泛型
 * 静态方法有一种情况需要注意一下，那就是在类中的静态方法使用泛型：静态方法无法访问类上定义的泛型；如果静态方法操作的引用数据类型不确定的时候，必须要将泛型定义在方法上。
 * <p>
 * 即：如果静态方法要使用泛型的话，必须将静态方法也定义成泛型方法 。
 */

class StaticGenerator<T> {

    /**
     * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明（将这个方法定义成泛型方法）
     * 即使静态方法要使用泛型类中已经声明过的泛型也不可以。
     * 如：public static void show(T t){..},此时编译器会提示错误信息：
     * "StaticGenerator cannot be refrenced from static context"
     */
    public static <T> void show(T t) {

    }
}

/**
 * 3.5 泛型方法与可变参数
 * 再看一个泛型方法和可变参数的例子：
 */
class a {
    public static <T> void printMsg(T... args) {
        for (T t : args) {
            System.out.println("泛型测试" + "t is " + t);
        }
    }

    public static void main(String[] args) {
        printMsg("111", 222, "aaaa", "2323.4", 55.55);
    }

}

/**
 * 泛型上下边界
 * 在使用泛型的时候，我们还可以为传入的泛型类型实参进行上下边界的限制，如：类型实参只准传入某种类型的父类或某种类型的子类。
 * <p>
 */
class border {

    // 为泛型添加上边界，即传入的类型实参必须是指定类型的子类型
    public static void showKeyValue1(Generic<? extends Number> obj) {
        System.out.println("泛型测试" + "key value is " + obj.getKey());
    }

    // 为泛型添加下边界，即传入的类型实参必须是指定类型父类型
    public static void showKeyValue2(Generic<? super Integer> obj) {
        System.out.println("泛型测试" + "key value is " + obj.getKey());
    }

    //如果我们把泛型类的定义也改一下:
    class Generic1<T extends Number> {
        private T key;

        public Generic1(T key) {
            this.key = key;
        }

        public T getKey() {
            return key;
        }
    }

    //再来一个泛型方法的例子：
    //在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，
    // 即在泛型声明的时候添加
    //public <T> T showKeyName(Generic<T extends Number> container)，
    // 编译器会报错："Unexpected bound"
    public <T extends Number> T showKeyName(Generic<T> container) {
        System.out.println("container key :" + container.getKey());
        T test = container.getKey();
        return test;
    }

    public static void main(String[] args) {
        // 上边界
        Generic<Integer> generic2 = new Generic<Integer>(2222);
        Generic<Float> generic3 = new Generic<Float>(2.4f);
        Generic<Double> generic4 = new Generic<Double>(2.56);
        //这一行代码编译器会提示错误，因为String类型并不是Number类型的子类
        //showKeyValue1(generic1);
        showKeyValue1(generic2);
        showKeyValue1(generic3);
        showKeyValue1(generic4);
        //这一行代码也会报错，因为String不是Number的子类
//        Generic1<String> generic1 = new Generic1<String>("11111");
        // 下边界
        showKeyValue2(new Generic<Number>(2));
    }
}