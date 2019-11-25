package math;

/**
 * @author Eric
 * @Title: ZuiDaGongYueShu
 * @date 2019/9/3 13:25
 * @Description: TODO
 */
public class ZuiDaGongYueShu {
    public static void main(String args[]) {
        int i = get(65, 15);
        System.out.println(i);
    }

    public static int get(int a, int b) {
        int c=-1, min;

        if (a > b) {
            c = a % b;
            min = b;
        }else{
            c = b % a;
            min = a;
        }
        if(c == 0){
            return min;
        }
        return get(c,min);
    }
}
