package sort;

import java.util.Arrays;

/**
 * @author Eric
 * @Title: GuiBing
 * @date 2019/8/30 9:26
 * @Description: TODO
 */
public class GuiBing {


    public static void main(String[] args) {
        int[] array = new int[]{3, 3, 5, 1, 2, 4, 5, 8, 0, 12, 45, 2};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] array) {
        doSort(array, 0, array.length - 1);
    }

    private static void doSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;

        doSort(array, left, mid);
        doSort(array, mid + 1, right);

        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] array1 = Arrays.copyOfRange(array, left, mid+1);
        int[] array2 = Arrays.copyOfRange(array, mid+1, right+1);

        int index1 = 0;
        int index2 = 0;
        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] < array2[index2]) {
                array[left+index1 + index2] = array1[index1];
                index1++;
            } else {
                array[left+index1 + index2] = array2[index2];
                index2++;
            }
        }

        if (index1 == array1.length) {
            while (index2 < array2.length) {
                array[left+index1 + index2] = array2[index2];
                index2++;
            }
        } else {
            while (index1 < array1.length) {
                array[left+index1 + index2] = array1[index1];
                index1++;
            }
        }


    }


}
