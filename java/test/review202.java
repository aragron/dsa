import java.util.HashSet;

public class review202 {

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            int sum = getSum(n);
            if (sum == 1) {
                return true;
            }
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
                n = sum;
            }
        }
    }

    public static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int p = n % 10;
            n = n / 10;
            sum += p * p;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
