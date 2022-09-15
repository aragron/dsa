

public class review1004 {
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, count = 0;
        int length = nums.length;
        while (right < length) {
            if (nums[right] == 0) {
                ++count;
            }
            if (count > k) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }
            right++;
        }
        return length-left;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k  = 3;
        int ones = longestOnes(nums, k);
        System.out.println(ones);
    }
}
