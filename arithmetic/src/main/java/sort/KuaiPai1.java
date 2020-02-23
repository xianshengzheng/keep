package sort;

import java.util.Arrays;

/**
 * @author Eric
 * @Title: KuaiPai
 * @date 2019/8/29 16:58
 * @Description: TODO
 */
public class KuaiPai1 {
    public static void sort(int[] array) {
        int lastIndex = array.length - 1;
        int firstIndex = 0;

        doSort(array, firstIndex, lastIndex);

    }

    public static void doSort(int[] array, int firstIndex, int lastIndex) {
        if (firstIndex >= lastIndex) {
            return;
        }

        int p = partition(array, firstIndex, lastIndex);

        doSort(array, firstIndex, p-1);
        doSort(array, p + 1, lastIndex);
    }

    private static int partition(int[] array, int firstIndex, int lastIndex) {
        int p = array[lastIndex];
        int i = firstIndex;
        int j = firstIndex;

        while (j <= lastIndex) {
            if (array[j] < p) {
                int k = array[i];
                array[i] = array[j];
                array[j] = k;
                i ++;
            }
            j++;
        }
        array[lastIndex] = array[i];
        array[i] = p;

        return i;
    }

    public static void main(String args[]) {
        int[] a = {1, 3, 8, 4, 6, 1, 5, 123, 5, 76, 2};
        sort(a);
        Arrays.stream(a).forEach(System.out::println);
    }
}
