package dsa.arrayAndString;

public class leetcode35 {
    public static int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        } else if (target > nums[nums.length-1]) {
            return nums.length;
        }
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = left + ((right-left)>>1);
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid -1;
            } else {
                if (target <= nums[mid+1]){
                    return mid+1;
                }
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums, target));
    }
}
