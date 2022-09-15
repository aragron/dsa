package dsa.hash;

import java.util.*;

public class leetcode599 {

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minIndexSum = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int list1Index = map.get(list2[i]);
                if ( list1Index + i < minIndexSum) {
                    list.clear();
                    list.add(list2[i]);
                    minIndexSum = list1Index + i;
                }  else if (list1Index + i == minIndexSum) {
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "KFC","Tapioca Express", "Burger King"}, list2 = {"KFC", "Shogun", "Burger King"};
        String[] strings = findRestaurant(list1, list2);
        System.out.println(Arrays.toString(strings));

    }
}
