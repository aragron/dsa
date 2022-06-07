package dsa.leetcode;

public class Quest278 {
    public static void main(String[] args) {
        int i = firstBadVersion(5);
        System.out.println(i);
    }

    public static int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean isBadVersion(int version) {
        return version >= 4;
    }
}
