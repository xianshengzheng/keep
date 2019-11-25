package com.zhxiansheng.function;

import java.util.function.Function;

/**
 * @Author ZhengH
 * @Date 2019/11/25 17:32
 * Function函数接口中，有一个重要的方法apply()，作用为：传入一个参数生成一个结果。
 * 下面示例体会的什么是是传入一个过程，而非结果。
 * 如果不用Function那么每新增一个计算方式，就需要多新增一个方法。
 **/
public class TestFunction {
     private static int convert(int a, Function<Integer, Integer> b){
        return b.apply(a);
    }

    public static void main(String[] args) {
        int convert1 = TestFunction.convert(1, a -> a + 2);
        int convert2 = TestFunction.convert(2, a -> a * 4);
        System.out.println(convert1);
        System.out.println(convert2);

    }
}
