package dsa.hash;

import java.util.*;

public class leetcode249 {

    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            StringBuilder key = new StringBuilder();
            char[] chars = string.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                //todo 精华
                key.append(chars.length).append((chars[i] - chars[i - 1]  + 26)%26);
                System.out.println(key + " > " + string);
            }
            if (map.containsKey(key.toString())) {
                List<String> list = map.get(key.toString());
                list.add(string);
                map.put(key.toString(), list);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(string);
                map.put(key.toString(), list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strings = {"abc","bcd","acef","xyz","az","ba","a","z","al"};
        List<List<String>> lists = groupStrings(strings);
        for (List<String> list : lists) {
            System.out.println(list);
        }

    }
}
