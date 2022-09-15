package dsa.arrayAndString;

public class leetcode14 {

    public static String longestCommonPrefix(String[] strs) {
        int strCount = strs.length;
        if (strCount == 1) {
            return strs[0];
        }
        String str0 = strs[0];
        int[] ints = new int[str0.length()];
        int count = 0;
        for (int i = 0; i < str0.length(); i++) {
            char c = str0.charAt(i);
            for (int j = 1; j < strCount; j++) {
                if (strs[j].length() < i + 1
                        || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, count);
                }
            }
            count++;
        }
        System.out.println(count);
        return strs[0].substring(0, count);
    }

    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        System.out.println(longestCommonPrefix(strs));
    }
}
