package 装饰者;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Eric
 * @Title: client
 * @date 2019/8/28 15:30
 * @Description: TODO
 */
public class client {
    public static void main(String args[]) throws FileNotFoundException {
        ConcreteComponet c = new ConcreteComponet();
        Decorate d1 = new ConcreteDecorateA();
        Decorate d2 = new ConcreteDecorateB();

        d1.setComponent(c);
        d2.setComponent(d1);
        d2.operation();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("")));
    }
}
