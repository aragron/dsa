package dsa.array;

import java.util.Arrays;

public class leetcode167 {

    public static int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[] {low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            }else {
                --high;
            }
        }
        return new int[]{-1,-1};
    }



    public static void main(String[] args) {
//        int[] numbers = {2,4, 7, 11, 15};
//        int target = 9;

        int[] numbers = {3, 24, 50, 79, 88, 150, 345};
        int target = 200;

        int[] search = twoSum(numbers, target);
        System.out.println(Arrays.toString(search));
    }
}
