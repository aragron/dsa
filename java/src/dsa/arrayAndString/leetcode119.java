package dsa.arrayAndString;

import java.util.*;
import java.util.stream.Collectors;

public class leetcode119 {

    public static List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> list1 = new ArrayList<Integer>(Collections.singleton(1));
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        if (rowIndex == 1) {
            return list1;
        } else if (rowIndex == 2) {
            return list2;
        }
        List<Integer> collect = null;
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1,list1);
        map.put(2,list2);
        for (int i = 3; i <= rowIndex; i++) {
            int[] ints = new int[i];
            List<Integer> list = map.get(i - 1);
            Integer[] array = list.toArray(new Integer[0]);
            ints[0] = 1;
            ints[i-1] = 1;
            for (int j = 1; j < i-1; j++) {
                ints[j] = array[j-1] + array[j];
            }
            collect = Arrays.stream(ints).boxed().collect(Collectors.toList());
            map.put(i,collect);
        }
        return collect;
    }

    public static void main(String[] args) {
        List<Integer> row = getRow(3);
        System.out.println(row);
    }
}
