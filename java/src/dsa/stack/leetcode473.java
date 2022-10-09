package dsa.stack;

import java.util.Arrays;

public class leetcode473 {
    boolean[] visited;
    int len;
    int edge;
    public boolean makesquare(int[] matchsticks) {
        this.len = matchsticks.length;
        if (len<4){return false;}
        int sum = Arrays.stream(matchsticks).sum();
        if (sum%4 !=0){return false;}
        this.edge = sum/4;
        int value = edge;
        Arrays.sort(matchsticks);
        if (matchsticks[len-1]>value){return false;}
        this.visited = new boolean[len];
        boolean ret = dfs(matchsticks,0,value,4);
        return ret;
    }

    public boolean dfs(int[] matchsticks, int startIndex, int value, int count){
        if (value == 0){
            value = edge;
            count--;
            startIndex = 0;
        }
        if (count == 0){return true;}
        for (int i = startIndex; i < len; i++) {
            if(visited[i]){continue;}
            int num = matchsticks[i];
            if (value<num){break;}
            visited[i] = true;
            boolean dfs = dfs(matchsticks,i+1,value-num,count);
            if (!dfs){
                visited[i] = false;
                while (i+1<len && matchsticks[i]==matchsticks[i+1]){i++;}
            }else {
                return dfs;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        leetcode473 leetcode473 = new leetcode473();
        int[] matchsticks = {5,5,5,5,4,4,4,4,3,3,3,3};
        System.out.println(leetcode473.makesquare(matchsticks));
    }
}
