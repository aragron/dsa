package dsa.array;

import java.util.Arrays;

public class leetcode88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        }
        int k = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;

        for (int i = k ; i >= 0; i--) {
            if (p1 >= 0 && p2 >= 0) {
                if (nums1[p1] >= nums2[p2]) {
                    nums1[k--] = nums1[p1--];
                } else {
                    nums1[k--] = nums2[p2--];
                }
            } else if (p2 < 0){
                nums1[k--] = nums1[p1--];
            } else {
                nums1[k--] = nums2[p2--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

//        int[] nums1 = {2, 0};
//        int m = 1;
//        int[] nums2 = {1};
//        int n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
