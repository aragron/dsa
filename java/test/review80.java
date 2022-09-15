import java.util.Arrays;

public class review80 {

    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int index = 2;
        for(int i = 2; i < nums.length; i++){
            if(nums[index-2] != nums[i])
                nums[index++] = nums[i];
        }
        return index;
    }

    public static void preMoveArray(int[] nums, int startIndex, int step, int length){
        for (int j = 0; j < length; j++) {
            nums[startIndex-step] = nums[startIndex];
            startIndex++;
        }
    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int duplicates = removeDuplicates(nums);
        System.out.println(duplicates);
        System.out.println(Arrays.toString(nums));;
    }
}
