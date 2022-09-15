public class review209 {

    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int left = 0, right;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (right = 0; right < len; right++) {
            sum += nums[right];
            while (sum - nums[left] >= target) {
                sum -= nums[left];
                ++left;
            }
            if (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
//        int target = 7;
//        int[] nums = {2,3,1,2,4,3};

//        int target = 4;
//        int[] nums = {1,4,4};

        int target = 11;
        int[] nums = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(target, nums));

    }
}
