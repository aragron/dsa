package dsa.stack;

import java.util.*;

public class leetcode47 {
    List<List<Integer>> result;
    int len;
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.result = new ArrayList<>();
        this.len = nums.length;
        used = new boolean[len];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0,list);
        return result;
    }

    public void dfs(int[] nums, int index, List<Integer> list){
        if (index>= len){
            List<Integer> arrayList = new ArrayList<>(list);
            result.add(arrayList);
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]){continue;}
            int num = nums[i];
            if (i>0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;}
            used[i]=true;
            list.add(num);
            dfs(nums, index+1, list);
            used[i]=false;
            list.remove(index);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,1};
        leetcode47 leetcode47 = new leetcode47();
        List<List<Integer>> permute = leetcode47.permuteUnique(nums);
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }
}
