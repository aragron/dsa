package dsa.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {-5, 8, 9, -1, 7, 0, 3, -5, 4, 3, -6, 0, 10, 0};
        int[] ints = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, ints);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }

    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; // 初始化i, 左边有序序列的初始索引
        int j = mid + 1; //初始化j, 右边有序序列的初始索引
        int t = 0; // 指向temp数组的当前索引

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                ++t;
                ++i;
            } else {
                temp[t] = arr[j];
                ++t;
                ++j;
            }
        }

        while (i <= mid) {
            temp[t] = arr[i];
            ++t;
            ++i;
        }
        while (j <= right) {
            temp[t] = arr[j];
            ++t;
            ++j;
        }
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }
}
