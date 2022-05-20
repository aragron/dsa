package dsa.leetcode;

public class Quest70 {

    public static void main(String[] args) {
        int i = climbStairs(1);
        System.out.println(0);
    }

    public static int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
