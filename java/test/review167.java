import java.util.Arrays;

public class review167 {

    public static int[] twoSum(int[] numbers, int target)  {
        int len  = numbers.length;
        int left = 0, right = len -1;
        int sum ;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left+1, right+1};
            } else if (sum > target) {
                --right;
            }else {
                ++left;
            }
        }
        return new int[] {-1,-1};
    }
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] ints = twoSum(numbers, target);
        System.out.println(Arrays.toString(ints));
    }
}
