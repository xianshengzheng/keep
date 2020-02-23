package function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Author ZhengH
 * @Date 2019/11/26 18:00
 * BiFunction与Function类似，区别在于接受两个参数转换为一个参数。
 * compose和andThen功能是将多个function组合在一起，前者先执行里面的function(before)，后者先执行外部的function(after)
 **/
public class ComposeAndAndThenAndBiFunctionTest {
    public static void main(String[] args) {
        ComposeAndAndThenAndBiFunctionTest test = new ComposeAndAndThenAndBiFunctionTest();
        System.out.println(test.compute1(2, value -> value * 3, value -> value * value));
        System.out.println(test.compute2(2, value -> value * 3, value -> value * value));
        System.out.println(test.compute3(1, 3, Integer::sum));
        System.out.println(test.compute4(1, 3, Integer::sum, x -> x * x));
    }

    public int compute1(int a, Function<Integer, Integer> fun1, Function<Integer, Integer> fun2) {
        return fun1.compose(fun2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> fun1, Function<Integer, Integer> fun2) {
        return fun1.andThen(fun2).apply(a);
    }

    public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    public int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction1, Function<Integer, Integer> biFunction2) {
        return biFunction1.andThen(biFunction2).apply(a, b);
    }

}
