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
//状态转移表法
    public class qipan1 {

        public int f(int[][] w, int n) {
            int[][] status = new int[n][n];

            //构建第一行
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum = sum + w[0][i];
                status[0][i] = sum;
            }
            sum = 0;
            //构建第一列
            for (int i = 0; i < n; i++) {
                sum = sum + w[i][0];
                status[i][0] = sum;
            }
            //动态规划
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    int min = status[i - 1][j] < status[i][j - 1] ? status[i - 1][j] : status[i][j - 1];
                    status[i][j] = min + w[i][j];
                }
            }

            for (int[] ints : status) {
                for (int anInt : ints) {
                    System.out.print(anInt + ",");
                }
                System.out.println("");

            }
            return status[n - 1][n - 1];
        }

        public static void main(String[] args) {
            qipan1 qipan1 = new qipan1();
            int[][] w = new int[][]{{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
            System.out.println(qipan1.f(w, 4));
        }
    }
