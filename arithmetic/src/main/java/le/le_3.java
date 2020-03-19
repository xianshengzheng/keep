package le;

import java.util.ArrayList;
import java.util.List;

public class le_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        List<List<Character>> status = new ArrayList<>();
        List<Character> arrayList = new ArrayList<>();
        arrayList.add(chars[0]);
        status.add(arrayList);
        for (int i = 1; i < chars.length; i++) {
            arrayList = new ArrayList<>();
            arrayList.add(chars[i]);
            if (!status.get(i - 1).contains(chars[i])) {
                arrayList.addAll(status.get(i - 1));
                status.add(arrayList);
                continue;
            } else {
                int j = i - 1;
                while (j >= 0 && chars[j] != chars[i]) {
                    arrayList.add(chars[j]);
                    j--;
                }
                status.add(arrayList);
            }
        }
        int max = -1;
        for (List<Character> characters : status) {
            if (characters.size() > max) {
                max = characters.size();
            }
        }

        return max;
    }


    // 滑动窗口
    public int lengthOfLongestSubstring1(String s) {

        char[] chars = s.toCharArray();
        int i = 0, j = 0, max = 0;
        while (j < chars.length) {
            int k = i;
            for (; k < j; k++) {
                if (chars[k] == chars[j]) {
                    i = k + 1;
                    break;
                }
            }

            max = Math.max(max, j - i + 1);
            if (k == j) {
                j++;
            }
        }

        return max;
    }

}
