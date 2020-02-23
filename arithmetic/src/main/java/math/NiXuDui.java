package math;

import java.util.Arrays;

/**
 * @author ZhengH
 * @date 2019/12/24 15:33
 * 给定一个长度为n的整数数列，请你计算数列中的逆序对的数量。
 *
 * 逆序对的定义如下：对于数列的第 i 个和第 j 个元素，如果满足 i < j 且 a[i] > a[j]，则其为一个逆序对；否则不是。
 *
 * 输入格式
 * 第一行包含整数n，表示数列的长度。
 *
 * 第二行包含 n 个整数，表示整个数列。
 *
 * 输出格式
 * 输出一个整数，表示逆序对的个数。
 *
 * 数据范围
 * 1≤n≤100000
 * 输入样例：
 * 6
 * 2 3 4 5 6 1
 * 输出样例：
 * 5
 **/
public class NiXuDui {
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

    private static int merge(int[] array, int left, int mid, int right) {
        int[] array1 = Arrays.copyOfRange(array, left, mid+1);
        int[] array2 = Arrays.copyOfRange(array, mid+1, right+1);

        int index2 = 0;
        int index1 = 0;
        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] < array2[index2]) {
                array[left+index1 + index2] = array1[index1];
                index1++;
            } else {
                array[left+index1 + index2] = array2[index2];
                index2++;
            }
        }
        int result = index2;

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

    return result;
    }

}
