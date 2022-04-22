package dsa.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] input = {-1, -2, 31, 9, 10};
        int[] ints = selectSort(input);
        System.out.println("最大值排序：" + Arrays.toString(ints));
    }

    public static int[] selectSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int max = arr[0];
            int index = 0;
            for (int j = 0; j < length - i; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    index = j;
                }
            }
            if (index != length - i - 1) {
                arr[index] = arr[length - i - 1];
                arr[length - i - 1] = max;
            }
        }
        return arr;
    }


}
