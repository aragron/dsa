package dsa.queue;

import java.util.*;

public class leetcode269 {
    public String alienOrder(String[] words) {
        int len = words.length;
        if (len == 0){return "";}

        Map<Character, Set<Character>> adj = new HashMap<>(26);
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c,new HashSet<>());
            }
        }

        int[] inDegree = new int[26];
        for (int i = 0; i < len-1; i++) {
            char[] chars1 = words[i].toCharArray();
            char[] chars2 = words[i+1].toCharArray();
            int minLen = Math.min(chars1.length,chars2.length);
            for (int j = 0; j < minLen; j++) {
                if (chars1[j] != chars2[j]){
                    if (!adj.get(chars1[j]).contains(chars2[j])){
                        adj.get(chars1[j]).add(chars2[j]);
                        inDegree[chars2[j]-'a']++;
                    }
                    break;
                }
                if (j == minLen-1 && words[i].length() > words[i+1].length()){
                    return "";
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c : adj.keySet()) {
            if (inDegree[c-'a'] == 0) {
                queue.offer(c);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            Character top = queue.poll();
            stringBuilder.append(top);

            Set<Character> successors = adj.get(top);
            for (Character successor : successors) {
                inDegree[successor - 'a']--;
                if (inDegree[successor - 'a'] == 0) {
                    queue.offer(successor);
                }
            }
        }

        if (stringBuilder.length() == adj.size()) {
            return stringBuilder.toString();
        }
        return "";
    }

    public static void main(String[] args) {
        leetcode269 leetcode269 = new leetcode269();
        String[] words = {"wrt","wrf","er","ett","rftt"};
        String s = leetcode269.alienOrder(words);
        System.out.println(s);
    }
}
