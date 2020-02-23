package dongtaiguihua.package0_1;

/**
 * @author ZhengH
 * @date 2020/1/8 19:42
 * 对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品装入背包，
 * 在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少呢？
 **/

//动态规划
public class package2 {

    private int fun(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; ++i) { // 初始化states
            for (int j = 0; j < w + 1; ++j) {
                states[i][j] = -1;
            }
        }

        states[0][0] = 0; //构建第一行
        if (weight[0] < w) {
            states[0][weight[0]] = value[0];
        }

        for (int i = 1; i < n; i++) { //从第二行开始遍历
            for (int j = 0; j <= w; j++) { //不选择第i个
                if (states[i - 1][j] >= 0) states[i][j] = states[i - 1][j];
            }

            for (int j = 0; j <= w - weight[i]; ++j) {      //选择第i个
                int v = states[i - 1][j] + value[i];
                if (v > states[i][j + weight[i]]) {
                    states[i][j + weight[i]] = v;
                }

            }
        }

        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n - 1][j] > maxvalue) maxvalue = states[n - 1][j];
        }
        return maxvalue;
    }

    public static void main(String[] args) {
        package2 package2 = new package2();
        System.out.println(package2.fun(new int[]{2, 2, 4, 6, 3}, new int[]{3, 4, 8, 9, 6}, 5, 9));
    }

}
