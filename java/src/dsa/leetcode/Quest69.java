package dsa.leetcode;

public class Quest69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int low = 0, high = x;
        int target = -1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if ((long)mid * mid > x) {
                high = mid -1;
            }else if ((long)mid * mid < x) {
                low = mid +1;
            } else {
                target = mid;
                break;
            }
        }
        if (target == -1 && (long)high * high > x) {
            target = high -1;
        } else if (target == -1 &&(long) high * high <= x){
            target = high;
        }
        return target;
    }

}
