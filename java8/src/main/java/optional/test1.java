package optional;

import java.util.Optional;

/**
 * @Author ZhengH
 * @Date 2019/12/3 19:38
 **/
public class test1 {
    public static void main(String[] args) {
        Optional<String> optional = Optional.empty();
        System.out.println(optional);

        System.out.println(optional.orElse("1232"));
        System.out.println(optional.orElseGet(() -> "123"));

        System.out.println("------------");
        Optional<String> hello = Optional.of("hello");
        hello.ifPresent(System.out::println);


    }
}
