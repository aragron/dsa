package dsa.dac;

import java.time.LocalDateTime;

public class Fibonacci {
    public static void main(String[] args) {
        long fibonacci = fibonacci(70);

        LocalDateTime start = LocalDateTime.now();
        System.out.println(fibonacci);
        LocalDateTime end = LocalDateTime.now();
        System.out.println(start);
        System.out.println(end);
    }

    static long[] mArray = new long[8001];

    public static long fibonacci(int n) {
        if (n == 1 || n == 2) {
            return mArray[n] = 1;
        }
        if (mArray[n] == 0) {
            mArray[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return mArray[n];
    }
}
