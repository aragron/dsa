import java.util.Arrays;
import java.util.Random;

public class review215 {

    private final static Random random = new Random(System.currentTimeMillis());

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];

    }

    public static void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 0};
        int k = 2;
        int kthLargest = findKthLargest(nums, k);
        System.out.println(kthLargest);
    }
}
