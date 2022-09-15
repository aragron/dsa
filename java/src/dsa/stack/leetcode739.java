package dsa.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class leetcode739 {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ints = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i-prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
