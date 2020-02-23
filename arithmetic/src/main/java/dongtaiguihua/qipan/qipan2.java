package dongtaiguihua.qipan;

/**
 * @author ZhengH
 * @date 2020/1/9 11:29
 * 假设我们有一个 n 乘以 n 的矩阵 w[n][n]。矩阵存储的都是正整数。
 * 棋子起始位置在左上角，终止位置在右下角。我们将棋子从左上角移动到右下角。每次只能向右或者向下移动一位。
 * 从左上角到右下角，会有很多不同的路径可以走。我们把每条路径经过的数字加起来看作路径的长度。
 * 那从左上角移动到右下角的最短路径长度是多少呢？
 * <p>
 * 1    3   5   9
 * 2    1   3   4
 * 5    2   6   7
 * 6    8   4   3
 **/
//状态转移方程
public class qipan2 {

    private int[][] w = new int[][]{{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
    private int n = 4;
    private int[][] status = new int[4][4];

    private int f(int i, int j) {
        if (i == 0 && j == 0) {
            return w[i][j];
        }
        if (status[i][j] > 0) {
            return status[i][j];
        }

        int minLeft = Integer.MAX_VALUE; //到左边最小的值
        if (j - 1 >= 0) {
            minLeft = f(i, j - 1);
        }
        int minUp =  Integer.MAX_VALUE; //到上面最小的值
        if (i - 1 >= 0) {
            minUp = f(i - 1, j);
        }

        int result = Math.min(minLeft,minUp) + w[i][j];
        status[i][j] = result;
        return result;
    }

    public static void main(String[] args) {
        qipan2 qipan1 = new qipan2();
        System.out.println(qipan1.f(3,3));
    }
}
