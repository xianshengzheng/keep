package sort;

import java.util.Arrays;

/**
 * @author Eric
 * @Title: duipaixu
 * @date 2019/9/3 12:40
 * @Description: TODO
 */
public class duipaixu {

    public static void main(String args[]) {
        int[] a = {1, 4, 6, 2, 6, 7, 3};
        buildHeap(a);
        System.out.println(Arrays.toString(a));
    }

    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        // temp 保存 插入 的 叶子 节点 值， 用于 最后 的 赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {//无须 真正 交换， 单向 赋值 即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp 保存 父 节点 值， 用于 最后 的 赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            // 如果 有 右 孩子， 且 右 孩子 小于 左 孩子 的 值， 则 定位 到 右 孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            // 如果 父 节点 小于 任何 一个 孩子 的 值， 则 直接 跳出
            if (temp <= array[childIndex])
                break;
            //无须 真正 交换， 单向 赋值 即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }


    public static void buildHeap(int[] array) {
        // 从 最后 一个 非 叶子 节点 开始， 依次 做“ 下沉” 调整
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }





}
