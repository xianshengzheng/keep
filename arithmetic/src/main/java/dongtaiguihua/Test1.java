package dongtaiguihua;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhengH
 * @date 2020/1/13 15:34
 * 找出数组里面最大得顺子个数
 **/
public class Test1 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            Integer left = map.getOrDefault(num - 1, 0);
            Integer right = map.getOrDefault(num + 1, 0);
            int count = left + right + 1;
            max = Math.max(max, count);

            //将数据更新
            for (int i =  num - left; i <= num + right; i++) {
                map.put(i, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int[] a =new int[]{100,4,200,1,3,2};
        System.out.println(test1.longestConsecutive(a));
    }
}
