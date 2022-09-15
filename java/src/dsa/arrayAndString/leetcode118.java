package dsa.arrayAndString;

import java.util.*;
import java.util.stream.Collectors;

public class leetcode118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<Integer>(Collections.singleton(1));
        result.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        if (numRows == 1) {
            return result;
        } else if (numRows == 2) {
            result.add(list2);
            return result;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1,list1);
        map.put(2,list2);
        for (int i = 3; i <= numRows; i++) {
            int[] ints = new int[i];
            List<Integer> list = map.get(i - 1);
            Integer[] array = list.toArray(new Integer[0]);
            ints[0] = 1;
            ints[i-1] = 1;
            for (int j = 1; j < i-1; j++) {
                ints[j] = array[j-1] + array[j];
            }
            List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());
            map.put(i,collect);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(2);
        for (List<Integer> integers : generate) {
            System.out.println(integers);
        }
    }
}
