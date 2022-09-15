import java.util.HashSet;
import java.util.Iterator;

public class review349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                set2.add(num);
            }
        }
        int[] ints = new int[set2.size()];
        int index = 0;
        for (Integer integer : set2) {
            ints[index++] = integer;
        }
        return ints;
    }

    public static void main(String[] args) {

    }
}
