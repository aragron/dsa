package dsa.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
        int[] ints = shellSort(arr);

        System.out.println(Arrays.toString(ints));
    }

    public static int[] shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //[0,gap-1]为各个分组的第一个元素
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                // 插入排序
                if (arr[j] < arr[j-gap]) {
                    while (j - gap >=0 && temp < arr[j-gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    return arr;
    }
}
