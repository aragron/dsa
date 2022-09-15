package dsa.array;

public class leetcode11 {

    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, (j - i +1) * minHeight);
            System.out.println(max + ": " + i + " ==> " + j); //49: 1 ==> 7
        }
        return max;

//        int left = 0, right = height.length - 1;
//        int maxArea = Math.min(height[left], height[right]) * (right - left);
//        System.out.println(maxArea + ": " + left + " ==> " + right);
//        while (left < right) {
//            if (height[left] < height[right]) {
//                ++left;
//            } else {
//                --right;
//            }
//            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
//            System.out.println(maxArea + ": " + left + " ==> " + right); //49: 1 ==> 8
//        }
//        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
