import java.util.HashMap;

public class review219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            } else {
                map.put(num,i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,1,2,3};
        int  k = 2;
        boolean b = containsNearbyDuplicate(nums, k);
        System.out.println(b);
    }
}
