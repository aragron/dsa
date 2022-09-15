package dsa.heap;

import java.util.PriorityQueue;
import java.util.Properties;

public class leetcodeOffer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) {
            pq.add(num);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}
