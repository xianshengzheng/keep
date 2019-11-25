package Base;

/**
 * @author Eric
 * @Title: java
 * @date 2019/9/2 11:39
 * @Description: TODO
 */
public class Int {
    public static void main(String args[]) {
        Integer i = 127;
        Integer i1 = 127;
        System.out.println(i == i1);

        i = 128;
        i1 = 128;
        System.out.println(i == i1);

        i = new Integer(127);
        i1 = new Integer(127);
        System.out.println(i == i1);
    }
}
