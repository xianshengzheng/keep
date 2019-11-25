package math;

/**
 * @author Eric
 * @Title: GuiBing
 * @date 2019/8/30 9:26
 * @Description: TODO
 */
public class GuiBing {


    public static void sort(int[] array) {

        doSort(array, 0, array.length - 1);
    }

    public static void doSort(int[] array, int firstIndex, int lastIndex) {
        if (firstIndex == lastIndex) {
            return;
        }
        if (firstIndex + 1 == lastIndex) {
            if (array[firstIndex] > array[lastIndex]) {
                int tmp = array[firstIndex];
                array[firstIndex] = array[lastIndex];
                array[lastIndex] = tmp;
            }
            return;
        }
        int k = (firstIndex + lastIndex) / 2;
        doSort(array, firstIndex, k);
        doSort(array, k + 1, lastIndex);

        int i = firstIndex;
        int j = k + 1;
    }


}
