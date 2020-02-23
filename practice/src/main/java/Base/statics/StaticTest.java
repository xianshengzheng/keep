package Base.statics;

/**
 * @Author ZhengH
 * @Date 2019/12/10 10:40
 **/
public class StaticTest {
    public static void main(String[] args) {
        System.out.println("访问静态变量");
        System.out.println(InitialOrderTest.staticField);
        System.out.println("-------------------");
        System.out.println("new一个对象");
        new InitialOrderTest();
    }
}
