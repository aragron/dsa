package dsa.hash;

import java.util.*;
import java.util.stream.Collectors;

public class leetcode349 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        int[] ints = intersection(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }
}
