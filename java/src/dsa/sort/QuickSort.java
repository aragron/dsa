package dsa.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-5, 8, 9, -1, 7, 0, 3, -5, 4, 3, -6,0, 10, 0};
        System.out.println(Arrays.toString(arr));
        int[] ints = quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(ints));
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }
        int pivot = arr[left];
        int l = left;
        int r = right;
        int point = left;
        while (l < r) {
            if (arr[r] >= pivot) {
                r--;
            } else if (arr[r] < pivot) {
                arr[point] = arr[r];
                point = r;
            }

            if (arr[l] < pivot) {
                l++;
            } else if (arr[l] >= pivot) {
                arr[point] = arr[l];
                point = l;
            }
        }
        arr[point] = pivot;

        quickSort(arr, left, point - 1);
        quickSort(arr, point + 1, right);


        return arr;
    }
}
