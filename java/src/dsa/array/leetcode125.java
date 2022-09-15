package dsa.array;

public class leetcode125 {

    public static boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                builder.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder reverse = new StringBuilder(builder).reverse();
        return reverse.toString().equals(builder.toString());
    }

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";
        String s = ".,";
//        String s = "0P";
        System.out.println(isPalindrome(s));
    }
}
