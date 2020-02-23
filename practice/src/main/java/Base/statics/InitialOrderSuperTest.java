package Base.statics;

public class InitialOrderSuperTest {
    static {
        System.out.println("Super静态初始化块1");
    }
    /* 静态变量 */
     static String staticField = "Super静态变量";
    /* 变量 */
     String field = "Super变量";

    /* 静态初始化块 */
    static {
        System.out.println("Super静态初始化块2");
    }

    static {
//        System.out.println(staticField);
        System.out.println("Super静态初始化块3");
    }

    /* 构造器 */
     InitialOrderSuperTest() {
        System.out.println("Super构造器");
    }

    /* 初始化块 */ {
//        System.out.println(field);
        System.out.println("Super初始化块");
    }


}