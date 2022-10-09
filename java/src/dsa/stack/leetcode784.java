package dsa.stack;

import java.util.ArrayList;
import java.util.List;

public class leetcode784 {
    List<String> result;
    int length ;
    public List<String> letterCasePermutation(String s) {
        this.result = new ArrayList<>();
        this.length = s.length();
        StringBuilder builder = new StringBuilder();
        dfs(s,0,builder);
        return result;
    }

    public void dfs(String s, int index, StringBuilder builder) {
        if (index >= length) {
            result.add(builder.toString());
            return;
        }
        List<Character> list = new ArrayList<>();
        char origin = s.charAt(index);
        if (Character.isLetter(origin)){
            list.add(Character.toLowerCase(origin));
            list.add(Character.toUpperCase(origin));
        }else {
            list.add(origin);
        }
        for (char c : list) {
            builder.append(c);
            dfs(s,index+1,builder);
            builder.deleteCharAt(builder.length()-1);
        }
    }

    public static void main(String[] args) {
        leetcode784 leetcode784 = new leetcode784();
        String s = "a1b2";
        List<String> strings = leetcode784.letterCasePermutation(s);
        System.out.println(strings);
    }
}
