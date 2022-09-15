import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class review599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }
        ArrayList<String> list = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            String str = list2[i];
            if (map.containsKey(str)) {
                if (i + map.get(str) < minSum) {
                    list.clear();
                    list.add(str);
                    minSum = i + map.get(str);
                }else if (i + map.get(str) == minSum) {
                    list.add(str);
                }
            }
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {

    }
}
