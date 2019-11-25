package sort;

import java.util.Arrays;

/**
 * @author Eric
 * @Title: KuaiPai
 * @date 2019/8/29 16:58
 * @Description: TODO
 */
public class KuaiPai {
    public static void sort(int[] array) {
        int lastIndex = array.length - 1;
        int firstIndex = 0;

        doSort(array, firstIndex, lastIndex);

    }

    public static void doSort(int[] array, int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int i = firstIndex, j = lastIndex;
            int k = array[firstIndex];
            while (i < j) {
                while (i < j && array[j] >= k) {
                    j--;
                }
                array[i] = array[j];
                while (i < j && array[i] <= k) {
                    i++;
                }
                array[j] = array[i];
            }
            array[i] = k;
            doSort(array, firstIndex, i - 1);
            doSort(array, i + 1, lastIndex);
        }

    }

    public static void main(String args[]) {
        int[] a = {1, 3, 8, 4, 6, 1, 5, 123, 5, 76, 2};
        sort(a);
        Arrays.stream(a).forEach(System.out::println);
    }
}
