package dsa.queue;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode279 {

    public static void main(String[] args) {
        int n = 13;
//        leetcode279 leetcode279 = new leetcode279();
//        System.out.println(leetcode279.numSquares(n));
        System.out.println(Math.sqrt(n));
    }
    Queue<Integer> queue;
    public int numSquares(int n) {
        queue = new LinkedList<Integer>();
        queue.offer(n);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = size; i > 0; i--) {
                int poll = queue.poll();
                int sq = (int) Math.sqrt(poll);
                if (sq*sq == poll) {



                    return step;
                } else {
                    for (int j = sq; j > 0; j--) {
                        int diff = poll - j*j;
                        queue.offer(diff);
                    }
                }
            }
        }
        return step;
    }
}
