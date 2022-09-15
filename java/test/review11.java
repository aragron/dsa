public class review11 {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = Math.min(height[left], height[right]) * (right - left);
        while (left < right) {
            if (height[left] <= height[right]) {
                ++left;
                maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            } else {
                --right;
                maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
