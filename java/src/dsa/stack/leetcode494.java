package dsa.stack;

public class leetcode494 {
    public int findTargetSumWays(int[] nums, int target) {
        int length = nums.length;
        if (length == 1) {
            return target == nums[0] || target + nums[0] == 0 ? 1 : 0;
        }

        return dfs(nums, target, 0, 0);
    }

    public int dfs(int[] nums, int target, int initNum, int position) {
        if (position == nums.length - 1) {
            int ret = 0;
            if (initNum + nums[position] == target) {
                ret++;
            }
            if (initNum - nums[position] == target) {
                ret++;
            }
            return ret;
        } else {
            return dfs(nums, target, initNum + nums[position], 1 + position)
                    + dfs(nums, target, initNum - nums[position], 1 + position);
        }
    }

    public static void main(String[] args) {
        leetcode494 fun = new leetcode494();
        int[] nums = {1, 1, 1, 1, 1};
        int ways = fun.findTargetSumWays(nums, 3);
        System.out.println(ways);
    }
}
