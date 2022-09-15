import java.util.*;

public class review49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        //String[] strs = {"a"};
//        List<List<String>> lists = groupAnagrams(strs);
//        for (List<String> list : lists) {
//            System.out.println(list);
//
    }
}
