package predicate;

import java.util.function.Predicate;

/**
 * @Author ZhengH
 * @Date 2019/11/29 13:42
 * predicate  输入一个参数返回true或false。注意也是传递过程
 **/
public class Predicate1 {
    public static void main(String[] args) {
        Predicate<String> predicate = a->a.length()>2;
        String test1 ="12345";
        String test2 ="1";
        System.out.println(predicate.test(test1));
        System.out.println(predicate.test(test2));
    }
}
