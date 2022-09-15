package dsa.arrayAndString;

public class leetcode167 {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int low = 0, high = len - 1;
        while (low < high) {
            if (numbers[low] + numbers[high] == target) {
                return new int[]{low+1, high+1};
            } else if (numbers[low] + numbers[high] > target) {
                high--;
            } else {
                low++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

    }
}
