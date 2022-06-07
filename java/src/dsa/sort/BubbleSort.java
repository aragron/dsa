package dsa.sort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] input = {-1, -2, 3, 9, 10};
        int[] ints = bubbleSort(input);
        System.out.println(Arrays.toString(ints));

        System.out.println("---------------------");
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000); //生成一个[0, 8000000) 数
        }

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime now = LocalDateTime.now();
        System.out.println("排序前的时间是： " + dtf2.format(now));
        //测试冒泡排序
        //bubbleSort(arr);
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println("排序后的时间是： " + now2.format(dtf2));

    }

    public static int[] bubbleSort(int[] arr) {
        long count = 0;
        boolean flag = false;
        for (int j = arr.length; j >= 1; j--) {
            for (int i = 0; i < j - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                count++;
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
        System.out.println("排序次数：" + count);
        return arr;
    }

    public static void bubbleSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int j = arr.length; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}

