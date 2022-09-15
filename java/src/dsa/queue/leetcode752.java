package dsa.queue;

import java.util.*;

public class leetcode752 {


    public int openLock(String[] deadends, String target) {
        String init = "0000";
        if (init.equals(target)){return 0;}

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains(init)){return -1;}

        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(init);
        Set<String> seen = new HashSet<>();
        seen.add(init);

        while (!queue.isEmpty()){
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                List<String> nextStatusList = nextStatus(status);
                for (String nextStatus : nextStatusList) {
                    if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if (nextStatus.equals(target)){
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }
        return -1;
    }

    public List<String> nextStatus(String status){
        List<String> ret = new ArrayList<>();
        if (status == null) {return ret;}
        char[] chars = status.toCharArray();
        for (int i = 0; i < 4; i++) {
            char num = chars[i];
            chars[i] = numPrev(num);
            ret.add(new String(chars));
            chars[i] = numSucc(num);
            ret.add(new String(chars));
            chars[i] = num;
        }
        return ret;
    }
    public char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }
}
