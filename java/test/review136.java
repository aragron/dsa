public class review136 {

    public static int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
