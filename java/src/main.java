import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        Integer x = 23;
        Integer y = x>>>1;
        System.out.println(y);
        //String i = Integer.toBinaryString(5);
        //System.out.println(i);
        ArrayList<Integer> list = new ArrayList<>();
    }

    public static int countOdds(int low, int high) {

        return (high - low + (high & 1) + (low & 1)) >> 1;
    }

    public static double average(int[] salary) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int sum = 0;
        for (int value : salary) {
            sum += value;
            maxValue = Math.max(maxValue, value);
            minValue = Math.min(minValue, value);
        }
        return (double) (sum - maxValue - minValue) / (salary.length - 2);
    }

    public static int hammingWeight(long n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}