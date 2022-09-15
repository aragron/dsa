public class review27 {

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int p = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[p++] = nums[i];
            }
        }
        return p;
    }

    public static void main(String[] args) {

    }
}
