import java.util.HashMap;

public class review159 {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int right = 0, left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int length = chars.length;
        while (right < length) {
            char rightChar = chars[right];
            Integer count = map.getOrDefault(rightChar, 0);
            map.put(rightChar, count + 1);
            if (map.size() > 2) {
                char leftChar = chars[left];
                Integer leftCount = map.get(leftChar);
                if (leftCount == 1) {
                    map.remove(leftChar);
                } else {
                    map.put(leftChar, leftCount - 1);
                }
                left++;
            }
            right++;
        }
        return length - left;
    }

    public static void main(String[] args) {
        String s = "ccaabbb";
        int i = lengthOfLongestSubstringTwoDistinct(s);
        System.out.println(i);
    }
}
