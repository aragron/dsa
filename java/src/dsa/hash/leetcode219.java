package dsa.hash;

import java.util.HashMap;
import java.util.Map;

public class leetcode219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    } 

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        boolean b = containsNearbyDuplicate(nums, k);
        System.out.println(b);
    }
}
