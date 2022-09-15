package dsa.arrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class leetcode56 {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        ArrayList<int[]> listArray = new ArrayList<>();
        int[] tmp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int L0 = tmp[0], R0 = tmp[1];
            int L1 = intervals[i][0], R1 = intervals[i][1];
            if (L0 <= L1 && L1 <= R0) {
                tmp = new int[]{L0, Math.max(R0,R1)};
            } else if (L0 <= L1 && L1 > R0) {
                listArray.add(tmp);
                tmp = intervals[i];
            }
        }
        listArray.add(tmp);
        return listArray.toArray(new int[listArray.size()][]);
    }

    public static void main(String[] args) {
        //int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals = {{1,4},{4,5}};
        int[][] merge = merge(intervals);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
