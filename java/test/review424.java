import java.util.Arrays;

public class review424 {

    public int characterReplacement(String s, int k) {
        int right = 0, left = 0, historyMaxCount = 0;
        int[] charCount = new int[26];
        char[] chars = s.toCharArray();
        int length = chars.length;
        while (right < length) {
            char rightChar = chars[right];
            charCount[rightChar-'A']++;
            historyMaxCount = Math.max(historyMaxCount, charCount[rightChar-'A']);
            if (right-left+1 > historyMaxCount + k) {
                charCount[chars[left] -'A']--;
                left++;
            }
            right++;
        }
        return length-left;
    }

    public static void main(String[] args) {
        int[] charCount = new int[26];
        System.out.println(Arrays.toString(charCount));
    }
}
