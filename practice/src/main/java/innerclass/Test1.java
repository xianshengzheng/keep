package innerclass;

/**
 * @author Eric
 * @Title: InnerClassTest
 * @date 2019/8/28 10:43
 * @Description:
 * 1.外部类的成员变量
 * 2.外部方法或作用域内的局部变量
 * 3.外部方法的参数
 * <p>
 * 而第一种变量是不需要声明为final的，但后两种是需要声明为final的。那这是为什么呢？
 * 不急，我们首先来看第一个知识点。
 * <p>
 * 知识点一，匿名内部类同所有类一样，都是有构造函数的，只不过这个构造函数是隐式的，虽然是内部类，但是经过编译之后，
 * JVM还是会为匿名内部类生成单独的class文件的，如下述代码所示。编译前：
 * <p>
 * public class Outer {
 * <p>
 * String string = "";
 * <p>
 * void outerTest(final char ch){
 * final Integer integer = 1;
 * Inner inner = new Inner() {
 * void innerTest() {
 * System.out.println(string);
 * System.out.println(ch);
 * System.out.println(integer);
 * }
 * };
 * }
 * <p>
 * public static void main(String[] args) {
 * new Outer().outerTest(' ');
 * }
 * <p>
 * class Inner {
 * }
 * <p>
 * }
 * <p>
 * 编译后内部类对应的class文件反编译后的代码：
 * class Outer$1extends Outer.Inner
 * {
 * Outer$1(Outer paramOuter, char paramChar, Integer paramInteger)
 * {
 * super(paramOuter);
 * }
 * <p>
 * void innerTest()
 * {
 * System.out.println(this.this$0.string);
 * System.out.println(this.val$ch);
 * System.out.println(this.val$integer);
 * }
 * }
 * 打开这个文件我们不仅会看到该类不仅有构造函数，而且匿名内部类引用的局部变量和方法参数以及外部类的引用都会被当做该构造函数的参数，
 * 但是我们发现外部类的成员变量却并非如此，而是通过外部类的引用来访问。
 * 好了到现在为止我们应该能回答为什么匿名内部类访问外部类的成员变量时，该变量无须final修饰，答案就是『没必要』。
 * 因为我们都知道，非静态内部类的对象都保存了外部类的对象的引用，因而内部类中对任何外部类成员变量的修改都会真实地反应到外部类实例本身，
 * 所以不需要用final来修饰它。接下来我们继续分析为啥局部变量和方法参数就需要被final，让我们再来学习两个知识点。
 * <p>
 * 知识点二，在Java的参数传递中，当基本类型作为参数传递时，传递的是值的拷贝，无论你怎么改变这个拷贝，原值是不会改变的；当对象作为参数传递时，
 * 传递的是对象的引用的拷贝，无论你怎么改变这个新的引用的指向，原来的引用是不会改变的（当然如果你通过这个引用改变了对象的内容，那么改变实实在在发生了）。
 * <p>
 * 知识点三，当final修饰基本类型变量时，不可更改其值，当final修饰引用变量时，不可更改其指向，只能更改其对象的内容。
 * 有了上面的基础，再回到我们的问题，试想，假设允许对外部局部变量不加final，那当你在匿名内部类里面尝试改变外部基本类型的变量的值的时候，
 * 或者改变外部引用变量的指向的时候，表面上看起来好像都成功了，但实际上并不会影响到外部的变量。
 * <p>
 * 所以，Java为了不让自己看起来那么奇怪，才加了这个final的限制。详细点说，之所以要加final，斗胆站在一个语言设计者的角度想，
 * 其根本原因或许是这样的：Java父：按照我之前的设计，在匿名内部类里面对外部局部变量的修改实际上是无法生效的，那既然无法生效，
 * 我就不让他们修改了呗，有什么办法呢？
 * Java母：你说的这种情况下，不管外部局部变量是不是final的，它在匿名内部类的作用域内，所实际表现出来的现象本质上就是final的，
 * 所以，要不给它约束个final？
 * Java父与Java母一拍即合，愉快地高呼『final大法好』！
 * 并且书写了以下声明：Java开发者们，如果你们想要在匿名内部类里面使用外部的局部变量或方法参数，那抱歉受限于语言设计，
 * 这个外部的变量只能声明为final的了。当然在JDK 1.8及以后，看起来似乎编译器取消了这种限制，没有被声明为final的变量或参数也可以在匿名内部类内部被访问了。
 * <p>
 * 但实际上是因为Java 8引入了effectively final的概念
 * （A variable or parameter whose value is never changed after it is initialized is effectively final）。
 * 所以，实际上是诸如effectively final的变量或参数被Java默认为final类型，所以才不会报错
 * （最简单的测试方式：将上述代码integer变量取消final修饰（effectively final），试一下，在下面对其重新赋值（not effectively final），再试一下），
 * 而上述的根本原因没有任何变化。
 */
public class Test1 {
    /*内部类能狗直接修改外部类的成员变量，不需要指定。
     因为内部类访问外部类的成员变量的时候。持有的是外部类的一个引用。
     修改外部类的成员变量，外部类能感知到。保证了数据的一致性。所以可以不用指定final。

     总结： 1. 设计者为了保证内部类与外部类的数据一致性。保证所有内部类的修改外部类都能感知得到。所以引用了final。
            2. 作用域问题，方法的结束局部
    */
    int a = 3;
    Man man = new Man("Tom");

    class Inner {
         void test() {
            a++;
            man = new Man("lisi");
        }

    }

    public static void main(String args[]) {
        Test1 out = new Test1();
        System.out.println(out);
        Inner inner = out.new Inner();
        inner.test();
        System.out.println(out);
    }


    @Override
    public String toString() {
        return "Test1{" +
                "a=" + a +
                ", man=" + man +
                '}';
    }
}
