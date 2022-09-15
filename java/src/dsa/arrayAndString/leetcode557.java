package dsa.arrayAndString;

public class leetcode557 {

    public static String reverseWords(String s) {
        String[] splitArray = s.split("\\s+");
        for (int i = 0; i < splitArray.length; i++) {
            String  split = splitArray[i];
            char[] chars = split.toCharArray();
            swap(chars,0, chars.length-1);
            splitArray[i] = new String(chars);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < splitArray.length - 1; i++) {
            builder.append(splitArray[i]);
            builder.append(' ');
        }
        builder.append(splitArray[splitArray.length-1]);
        return builder.toString();
    }

    public static void swap(char[] s, int left, int right) {
        while (left <= right) {
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
            right--;
            left++;
        }
    }
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
