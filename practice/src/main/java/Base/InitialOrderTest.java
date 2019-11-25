package Base;

public class InitialOrderTest {
    static {
        System.out.println("静态初始化块1");
    }
    /* 静态变量 */
    public static String staticField = "静态变量";
    /* 变量 */
    public String field = "变量";

    /* 静态初始化块 */
    static {
        System.out.println("静态初始化块2");
    }

    static {
        System.out.println(staticField);
        System.out.println("静态初始化块3");
    }

    /* 构造器 */
    public InitialOrderTest() {
        System.out.println("构造器");
    }

    /* 初始化块 */ {
        System.out.println(field);
        System.out.println("初始化块");
    }

    public static void main(String[] args) {
        new InitialOrderTest();
    }
}