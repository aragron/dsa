package dsa.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class leetcode1136 {
    public int minimumSemesters(int n, int[][] relations) {
        Set<Integer>[] set = new HashSet[n+1];
        for (int i = 1; i <= n; i++) {
            set[i] = new HashSet<>();
        }
        int[] array = new int[n + 1];
        for (int[] relation : relations) {
            array[relation[1]]++;
            set[relation[0]].add(relation[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (array[i] == 0) {
                queue.offer(i);
            }
        }
        int step = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer top = queue.poll();
                Set<Integer> nextSet = set[top];
                for (Integer next : nextSet) {
                    array[next]--;
                    if (array[next] == 0){
                        queue.offer(next);
                    }
                }
            }
            step++;
        }
        for (int i = 1; i < n; i++) {
            if (array[i] > 0){
                return -1;
            }
        }
        return step;
    }
}
