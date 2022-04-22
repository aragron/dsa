package dsa.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] input = {-1, -2, 31, 9, 10};
        int[] res = insertSort(input);
        System.out.println("最大值排序：" + Arrays.toString(res));
    }

    public static int[] insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >=0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }

        return arr;
    }
}
