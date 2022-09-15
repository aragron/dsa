import java.util.HashMap;

public class review205 {

    public static boolean isIsomorphic1(String s, String t) {
        HashMap<Character, Character> s2t = new HashMap<>();
        HashMap<Character, Character> t2s = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if ((s2t.containsKey(sChar) && s2t.get(sChar) != tChar)
                    || (t2s.containsKey(tChar) && t2s.get(tChar) != sChar)) {
                return false;
            }
            s2t.put(sChar,tChar);
            t2s.put(tChar,sChar);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(isIsomorphic1(s, t));
    }
}
