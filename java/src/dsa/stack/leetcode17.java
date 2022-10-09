package dsa.stack;

import java.util.ArrayList;
import java.util.List;

public class leetcode17 {
    List<String> result;
    char[][] chars;
    int[] array;
    public List<String> letterCombinations(String digits) {
        this.result = new ArrayList<>();
        this.chars = generalChars();
        int length = digits.length();
        if (length==0){return result;}
        this.array = new int[length];
        for (int i = 0; i < length; i++) {
            int num = digits.charAt(i)-'0';
            array[i]=num-2;
        }
        StringBuilder builder = new StringBuilder();
        int index = 0;
        dfs(index,builder);
        return this.result;
    }

    public void dfs(int index, StringBuilder builder){
        if (index >= array.length){
            result.add(builder.toString());
            return;
        }
        int num = array[index];
        for (char c : chars[num]) {
            if (c=='0'){continue;}
            dfs(index+1,builder.append(c));
            builder.deleteCharAt(index);
        }
    }

    public static char[][] generalChars() {
        int row = 8, column = 4;
        char[][] chars = new char[row][column];
        int pos = 0;
        char c = 'a';
        int count = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                count++;
                if (i != 5 && i != 7 && count % 4 == 3) {
                    chars[i][j]='0';
                    continue;
                }
                chars[i][j] = (char) (c + pos++);
            }
        }
        return chars;
    }

    public static void main(String[] args) {
        leetcode17 leetcode17 = new leetcode17();
        String digits = "23";
        List<String> strings = leetcode17.letterCombinations(digits);
        System.out.println(strings.toString());

    }
}
