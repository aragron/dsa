package dsa.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer value = map.getOrDefault(num, 0);
            map.put(num,++value);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        map.entrySet().forEach(queue::add);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }
}
