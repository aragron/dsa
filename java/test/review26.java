import java.util.Arrays;

public class review26 {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 1) {return 1;}
        int sp = 1;
        for (int fp = 1; fp < len; fp++) {
            if (nums[sp-1] != nums[fp]) {
                nums[sp] = nums[fp];
                sp++;
            }
        }
        return sp;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
