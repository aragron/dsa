package dsa.slidingWindowAndDoublePoint;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class leetcode1695 {
    public static int maximumUniqueSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        int result = 0;
        for (int right = 0; right < len; right++) {
            int num = nums[right];
            Integer orDefault = map.getOrDefault(num, 0);
            if (orDefault > 0) {
                set.add(num);
            }
            sum += num;
            map.put(num, ++orDefault);

            while (left < right && set.size() > 0) {
                int numLeft = nums[left];
                Integer integer = map.get(numLeft);
                if (integer == 1) {
                    map.remove(numLeft);
                } else if (integer == 2) {
                    set.remove(numLeft);
                    map.put(numLeft,--integer);
                } else {
                    map.put(numLeft,--integer);
                }
                left++;
                sum -= numLeft;
            }
            result = Math.max(result, sum);
        }
        return result;
    }

    public static int maximumUniqueSubArray2(int[] nums) {
        boolean[] hash = new boolean[(int) 1e4 + 1];
        int l = 0, r = 0;
        int len = nums.length;
        int ans = Integer.MIN_VALUE, cur = 0;
        while (r <= len) {
            int num = r < len ? nums[r] : -1;
            if (r < len && !hash[num]) {
                hash[num] = true;
                cur += num;
            } else {
                ans = Math.max(ans, cur);
                while (l < r && nums[l] != num) {
                    int sub = nums[l];
                    hash[sub] = false;
                    cur -= sub;
                    l++;
                }
                if (l != r) {
                    l++;
                }
            }
            r++;
        }
        return ans;
    }
    public static int arraySum(int[] nums, int left, int right){
        int len = nums.length;
        if (right >= len || left > right) {
            throw new RuntimeException("error parameter!");
        }
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums = {
                187,470,25,436,538,809,441,167,477,
                110,275,133,666,345,411,459,490,266,
                987,965,429,166,809,340,467,318,125,
                165,809,610,31,585,970,306,42,189,169,
                743,78,810,70,382,367,490,787,670,476,
                278,775,673,299,19,893,817,971,458,409,
                886,434};
        System.out.println(maximumUniqueSubArray(nums));
        System.out.println(arraySum(nums, 0, nums.length-1));
    }
}
