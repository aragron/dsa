package dsa.stack;

import java.util.LinkedList;

public class leetcode394 {

    int ptr;

    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
//                String digits = getDigits(s);
                StringBuilder ret = new StringBuilder();
                while (ptr < s.length() && Character.isDigit(s.charAt(ptr))) {
                    ret.append(s.charAt(ptr++));
                }
                stk.addLast(ret.toString());
            } else if (Character.isLetter(cur) ) {
                // 获取一个字母并进栈
                StringBuilder ret = new StringBuilder();
                while (ptr < s.length() && Character.isLetter(s.charAt(ptr))) {
                    ret.append(s.charAt(ptr++));
                }
                stk.addLast(ret.toString());
            } else if (cur == '['){
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                //Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuilder t = new StringBuilder();
                StringBuilder t1 = new StringBuilder();
                while (!sub.isEmpty()){
                    t.append(sub.removeLast());
                }
                //String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t1.append(t);
                }
                // 将构造好的字符串入栈
                stk.addLast(t1.toString());
            }
        }
        StringBuilder t2 = new StringBuilder();
        while (!stk.isEmpty()){
            t2.insert(0,stk.removeLast());
        }
        return t2.toString();
    }

    public static void main(String[] args) {
        leetcode394 leetcode394 = new leetcode394();
        String n = "2[abc]3[cd]ef";
        System.out.println(leetcode394.decodeString(n));
        //System.out.println(decodeString(n));
    }
}
