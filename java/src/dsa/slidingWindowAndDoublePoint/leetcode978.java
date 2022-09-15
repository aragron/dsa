package dsa.slidingWindowAndDoublePoint;

public class leetcode978 {
    public static int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        int ret = 1;
        int left = 0, right = 0;
        while (right < len -1) {
            if (left == right) {
                if (arr[left] == arr[left+1]) {
                    left++;
                }
                right++;
            } else {
                if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
                    right++;
                } else if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    right++;
                } else {
                    left = right;
                }
            }
            System.out.println(left + " --> " + right);
            ret = Math.max(ret, right -left + 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(maxTurbulenceSize(arr));
    }
}
