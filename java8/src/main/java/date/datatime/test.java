package date.datatime;

import org.joda.time.DateTime;

import java.util.Arrays;

/**
 * @author ZhengH
 * @date 2019/12/18 10:08
 **/
public class test {
    public static void main(String[] args) {
        DateTime dateTime = new DateTime();
        System.out.println(dateTime);

        String s = dateTime.toString("yyyy-MM-dd hh:mm:ss.SSSa");
        String s1 = dateTime.toString("yyyy-MM-dd hh:mm:ss.SSS");
        System.out.println(s);
        System.out.println(s1);



    }
}
