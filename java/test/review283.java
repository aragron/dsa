public class review283 {

    public void moveZeroes(int[] nums) {
        int right = 0, left = 0, len = nums.length;
        while (right<len){
            if (nums[right] != 0) {
                int tmp = nums[left];
                nums[left++] = nums[right];
                nums[right] = tmp;
            }
            right++;
        }
    }
    public static void main(String[] args) {

    }
}
