package dsa.slidingWindowAndDoublePoint;

public class leetcode904 {
    public int totalFruit(int[] fruits) {
        int k = 2;
        int len = fruits.length;
        int[] kind = new int[len];
        int left = 0, right = 0;
        int count = 0;
        int res = 0;
        while (right < len) {
            if (kind[fruits[right]] == 0) {
                count++;
            }
            kind[fruits[right]]++;
            right++;

            while (count > k) {
                kind[fruits[left]]--;
                if (kind[fruits[left]] == 0) {
                    count--;
                }
                left++;
            }
            res = Math.max(res, right-left);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
