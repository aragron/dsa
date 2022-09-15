package dsa.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class leetcode20 {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!stack.isEmpty()) {
                Character peek = stack.peek();
                Character character = map.get(peek);
                if (character != null && character == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
