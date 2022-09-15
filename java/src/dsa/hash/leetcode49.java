package dsa.hash;

import java.util.*;

public class leetcode49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String s = sortString(str);
            if (map.containsKey(s)) {
                List<String> strings = map.get(s);
                strings.add(str);
                map.put(s,strings);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                map.put(s,strings);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static String sortString(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        StringBuilder result = new StringBuilder();
        for (char aChar : chars) {
            result.append(aChar);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
