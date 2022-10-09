package dsa.stack;

import java.util.*;

public class leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, // 来源
                     int len,       // 长度
                     int depth,     // 深度
                     Deque<Integer> path, //栈
                     boolean[] used,        // 历史访问
                     List<List<Integer>> res    // 结果
    ) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                System.out.println(i+"  递归之前 => " + path);
                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.removeLast();
                System.out.println(i+"递归之后 => " + path);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        leetcode46 solution = new leetcode46();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }
}
