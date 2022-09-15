package dsa.stack;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode150 {

    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                if (stack.size() < 2) {return -1;}
                int n1 = Integer.parseInt(stack.pop());
                int n2 = Integer.parseInt(stack.pop());
                stack.push(n1+n2+"");
            } else if (token.equals("-")) {
                if (stack.size() < 2) {return -1;}
                int n1 = Integer.parseInt(stack.pop());
                int n2 = Integer.parseInt(stack.pop());
                stack.push(n2-n1+"");
            }else if (token.equals("*")) {
                if (stack.size() < 2) {return -1;}
                int n1 = Integer.parseInt(stack.pop());
                int n2 = Integer.parseInt(stack.pop());
                stack.push(n1*n2+"");
            }else if (token.equals("/")) {
                if (stack.size() < 2) {return -1;}
                int n1 = Integer.parseInt(stack.pop());
                int n2 = Integer.parseInt(stack.pop());
                stack.push(((int)n2/n1)+"");
            } else {
                stack.push(token);
            }
        }
        return  stack.size() == 1 ? Integer.parseInt(stack.pop()) : -1;
    }
}
