package sort;

/**
 * @author Eric
 * @Title: MaoPao
 * @date 2019/8/27 16:58
 * @Description: TODO
 */
public class MaoPao {
    public static void main(String args[]) {
        int[] a = {3, 75, 2, 1, 4, 6, 3};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }


    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    public static void sort1(int[] a) {
        boolean flag = true;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
        }
    }
}
