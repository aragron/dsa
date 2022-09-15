package dsa.queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int ret = 0;
        Arrays.sort(coins);
        int coinTypeCount = coins.length;
        if (amount > coins[coinTypeCount-1]) {
            ret = dfs(coins, amount, coinTypeCount - 1);
        } else if (amount < coins[0]) {
            ret = -1;
        } else {
            int index = Arrays.binarySearch(coins, amount);
            if (index >=0){
                ret = 1;
            } else {
                int realIndex = -2-index;
                ret = dfs(coins, amount, realIndex);
            }
        }
        return ret;
    }

    public int dfs(int[] coins, int sum, int coinType){
        int ret = 0;
        int coin = coins[coinType];


        return 0;
    }

    public static void main(String[] args) {
        Integer[] coins = {1,2,5,8,9};
        int i = Arrays.binarySearch(coins, 3);

        System.out.println(-i - 2);
    }


}
