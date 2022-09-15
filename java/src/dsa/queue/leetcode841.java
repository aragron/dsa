package dsa.queue;

import java.util.*;

public class leetcode841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        Deque<Integer> stack = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        set.add(0);

        List<Integer> keys0 = rooms.get(0);
        if (keys0.size() == 0) {return false;}
        for (Integer key : keys0) {
            stack.push(key);
        }
        while (!stack.isEmpty()){
            Integer poll = stack.pop();
            if (set.contains(poll)){
                continue;
            }
            set.add(poll);
            if (set.size() == size) {return true;}
            List<Integer> keysList = rooms.get(poll);
            for (Integer key : keysList) {
                stack.push(key);
            }
        }
        return set.size() == size;
    }
}
