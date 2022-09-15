package dsa.hash;

import java.util.HashSet;
import java.util.Set;

public class leetcode136 {

    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int key : nums) {
            if (set.contains(key)) {
                set.remove(key);
            }else {
                set.add(key);
            }
        }
        if (set.size() == 1) {
            return set.iterator().next();
        }else {
            return -1;
        }

    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
