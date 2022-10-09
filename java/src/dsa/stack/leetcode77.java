package dsa.stack;

import java.util.ArrayList;
import java.util.List;

public class leetcode77 {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        this.result = new ArrayList<>();
        int start = 1;
        int end = n;
        List<Integer> list = new ArrayList<>();
        dfs(start,end,k,list);
        return result;
    }

    public void dfs(int start, int end, int count, List<Integer> list){
        if (count==0){
            ArrayList<Integer> arrayList = new ArrayList<>(list);
            this.result.add(arrayList);
            return;
        }
        for (int i = start; i <= end ; i++) {
            if (end-start+1<count){break;}
            list.add(i);
            int size = list.size();
            dfs(i+1,end,count-1,list);
            list.remove(size-1);
        }
    }

    public static void main(String[] args) {
        leetcode77 leetcode77 = new leetcode77();
        int n = 4, k=2;
        List<List<Integer>> combine = leetcode77.combine(n, k);
        for (List<Integer> list : combine) {
            System.out.println(list);
        }
    }
}
