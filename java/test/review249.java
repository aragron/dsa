import java.util.*;

public class review249 {

    public static List<List<String>> groupStrings(String[] strings) {
        ArrayList<String> singleList = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            if (string.length() == 1) {
                singleList.add(string);
            } else {
                char[] chars = string.toCharArray();
                StringBuilder diffs = new StringBuilder();
                for (int i = 1; i < chars.length; i++) {
                    int diff = (chars[i] - chars[i - 1] + 26) % 26;
                    if (diff<10) {
                        diffs.append("0").append(diff);
                    }else {
                        diffs.append(diff);
                    }
                }
                List<String> list = map.getOrDefault(diffs.toString(), new ArrayList<String>());
                list.add(string);
                map.put(diffs.toString(), list);
            }
        }
        List<List<String>> lists = new ArrayList<>(map.values());
        if (!singleList.isEmpty()) {
            lists.add(singleList);
        }
        return lists;
    }

    public static void main(String[] args) {
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        //String[] strings = {"ab", "ba"};
        List<List<String>> lists = groupStrings(strings);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
