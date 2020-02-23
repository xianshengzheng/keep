package Base.statics;

/**
 * 执行静态方法，会初始化这个类
 */
public class InitialOrderTest extends InitialOrderSuperTest{
    static {
        System.out.println("静态初始化块1");
    }
    /* 静态变量 */
     static String staticField = "静态变量";
    /* 变量 */
     String field = "变量";

    /* 静态初始化块 */
    static {
        System.out.println("静态初始化块2");
    }

    static {
//        System.out.println(staticField);
        System.out.println("静态初始化块3");
    }

    /* 构造器 */
     InitialOrderTest() {
        super();
        System.out.println("构造器");
    }

    /* 初始化块 */ {
//        System.out.println(field);
        System.out.println("初始化块");
    }

    public static void main(String[] args) {
        System.out.println("访问静态变量");
        System.out.println(InitialOrderSuperTest.staticField);
        System.out.println("-------------------");
        System.out.println("new一个对象");
        new InitialOrderTest();
    }
}