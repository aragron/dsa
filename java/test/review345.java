public class review345 {

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length-1;
        String base = "aeiouAEIOU";
        while (left < right) {
            while (left < right && base.indexOf(chars[left]) < 0) {
                left++;
            }
            while (left < right && base.indexOf(chars[right]) < 0) {
                right--;
            }
            if (left < right) {
                swap(chars,left,right);
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static void swap(char[] chars, int left, int right){
        char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
    }

    public static void main(String[] args) {
        String s = ".,";
        System.out.println(reverseVowels(s));

    }
}
