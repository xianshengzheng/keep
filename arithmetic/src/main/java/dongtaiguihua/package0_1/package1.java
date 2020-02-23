package dongtaiguihua.package0_1;

/**
 * @author ZhengH
 * @date 2020/1/8 19:42
 * 对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品装入背包，
 * 在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少呢？
 **/
//递归
public class package1 {
    private int maxV = Integer.MIN_VALUE; // 结果放到maxV中
    private int[] items = {2, 2, 4, 6, 3}; // 物品的重量
    private int[] value = {3, 4, 8, 9, 6}; // 物品的价值
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量

    private void fun(int i, int cw, int cv) {
        if (i == n || cw == w) {
            if (cv > maxV) maxV = cv;
            return;
        }

        fun(i + 1, cw, cv);

        if (cw + items[i] <= w) {
            fun(i + 1, cw + items[i], cv + value[i]);
        }
    }

    public static void main(String[] args) {
        package1 package1 = new package1();
        package1.fun(0,0,0);
        System.out.println(package1.maxV);
    }

}
