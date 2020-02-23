package predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author ZhengH
 * @Date 2019/11/29 13:42
 * predicate  输入一个参数返回true或false。注意也是传递过程
 **/
public class Predicate2 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Predicate2 predicate2 = new Predicate2();
        predicate2.condtionFilter(integers, x -> x % 2 == 0); //打印偶数
        System.out.println("----");
        predicate2.condtionFilter(integers,x->x%2!=0); //打印偶数
        System.out.println("----");
        predicate2.condtionFilter(integers, x -> x > 5); //大于5的数
    }

    public void condtionFilter(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(value -> {
                    if (predicate.test(value)) {
                        System.out.print(value+" ");
                    }
                }
        );
        System.out.println();
    }

}
