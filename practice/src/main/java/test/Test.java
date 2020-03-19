package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Eric
 * @Title: Test
 * @date 2019/9/3 15:53
 * @Description: TODO
 */
public class Test {
    private String name;

    public Test(String name) {
        this.name = name;
    }

    public void fun(Test test) {
        test = new Test("lisi");
        System.out.println(test);

    }

    public static void main(String[] args) {
        System.out.println("null".equals((String)null));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] status = new int[amount+1];

        for(int i =1;i<=amount;i++){
            int min = -1;
            for(int j =0;j<coins.length;j++){
                int coin = coins[j];
                if(i-coin > 0 && status[i-coin] != 0){
                    min = Math.min(min,status[i-coin]+1);
                }
                if(i-coin == 0){
                    status[i] = 1;
                    min = 1;
                }
            }
            status[i] = min;
        }
        return status[amount];
    }
}
