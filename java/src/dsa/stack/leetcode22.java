package dsa.stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode22 {
    static final char L = '(';
    static final char R = ')';
    char[] chars = new char[2];

    List<String> result;

    public boolean verifyBracket(String str) {
        int length = str.length();
        if (length == 0) {
            return true;
        }
        if (length % 2 == 1 || str.charAt(0) == R || str.charAt(length - 1) == L) {
            return false;
        }
        int balance = 0;
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c==L){
                balance++;
            }else {
                balance--;
            }
            if (balance<0){
                return false;
            }
        }
        return balance==0;
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder builder = new StringBuilder();

        this.chars[0]=L;
        this.chars[1]=R;

        this.result = new ArrayList<>();
        builder.append(L);
        dfs(builder,2*n);
        return this.result;
    }
    public void dfs(StringBuilder builder, int l){
        if (builder.length() == l){
            String s = new String(builder);
            boolean b = verifyBracket(s);
            if (b){
                this.result.add(s);
            }
        } else {
            for (char c : chars) {
                builder.append(c);
                int len = builder.length();
                dfs(builder, l);
                builder.delete(len-1,len);
            }
        }
    }

    public static void main(String[] args) {
        leetcode22 leetcode22 = new leetcode22();
        List<String> stringList = leetcode22.generateParenthesis(3);
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
