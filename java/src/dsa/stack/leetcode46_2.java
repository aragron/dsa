package dsa.stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode46_2 {
    List<List<Integer>> result;
    int length;
    Set<Integer> set;
    public List<List<Integer>> permute(int[] nums) {
        this.result = new ArrayList<>();
        this.length = nums.length;
        this.set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums,0,list);
        return result;
    }

    public void dfs(int[] nums, int index, List<Integer> list){
        if (index>=length){
            List<Integer> arrayList = new ArrayList<>(list);
            result.add(arrayList);
            return;
        }
        for (int num : nums) {
            if (set.contains(num)){continue;}
            set.add(num);
            list.add(num);
            dfs(nums, index+1, list);
            set.remove(num);
            list.remove(index);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        leetcode46_2 leetcode46_2 = new leetcode46_2();
        List<List<Integer>> permute = leetcode46_2.permute(nums);
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }
}
