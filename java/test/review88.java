import java.util.Arrays;

public class review88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, len = nums1.length;
        for (int i = len - 1; i >= 0; i--) {
            if (p1 >= 0 && p2 >= 0 && nums1[p1] >= nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            } else if (p2 >= 0){
                nums1[i] = nums2[p2];
                p2--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
