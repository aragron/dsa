package dsa.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode39 {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        if (target<candidates[0]){return new ArrayList<>();}
        dfs(candidates,target,0,list);
        return result;
    }

    public void dfs(int[] candidates, int target,int maxV, List<Integer> list){
        if (target==0){
            List<Integer> arrayList = new ArrayList<>(list);
            result.add(arrayList);
            return;
        }
        if (target<candidates[0]){return ;}
        int len = candidates.length;
        for (int i = 0; i < len; i++) {
            if (candidates[i]>target || candidates[i]<maxV){continue;}
            list.add(candidates[i]);
            int size = list.size();
            int newTarget = target-candidates[i];
            maxV = Math.max(maxV,candidates[i]);
            dfs(candidates, newTarget, maxV,list);
            list.remove(size-1);
        }
    }

    public static void main(String[] args) {
        leetcode39 leetcode39 = new leetcode39();
        int[] candidates = {2,3,5};int target = 8;
        List<List<Integer>> lists = leetcode39.combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
