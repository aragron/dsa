import java.util.*;

public class DemoTest {

    public static void main(String[] args) {
        int[] nums = {1,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        if(len == 1) {return;}
        int p = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                int tmp = nums[p];
                nums[p] = nums[i];
                nums[i]=tmp;
                p++;
            }
        }
    }

    public static boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] chips = new int[3][3][9];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                char c = board[row][column];
                if ('.' != c) {
                    int num = c - '1';
                    ++rows[row][num];
                    ++columns[column][num];
                    ++chips[row / 3][column / 3][num];
                    if (rows[row][num] > 1
                            || columns[column][num] > 1
                            || chips[row / 3][column / 3][num] > 1
                    ) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            String key = offsiteList(string);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(string);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public static String offsiteList(String str) {
        int len = str.length();
        if (len == 1) {
            return "-1";
        }
        char[] chars = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            int diff = (chars[i] - chars[i - 1] - 'a' + 26) % 26;
            if (diff < 10) {
                builder.append('0').append(diff);
            } else {
                builder.append(diff);
            }
        }
        return builder.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] letterList = new int[500];
        HashSet<Character> set = new HashSet<>();
        int p = 0;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            set.add(c);
            letterList[c - '0']++;

            if (set.size() > 2) {
                char c2 = chars[p];
                letterList[c2 - '0']--;
                if (letterList[c2 - '0'] == 0) {
                    set.remove(c2);
                }
                p++;
            }
        }
        return len - p;
    }

    public static int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int p = 0;
        int maxCount = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                maxCount++;
            }
            if (maxCount + k < i - p + 1) {
                if (nums[p] == 1) {
                    maxCount--;
                }
                p++;
            }
        }
        return len - p;
    }

    public static int characterReplacement(String s, int k) {
        int right = 0, left = 0, historyMaxCount = 0;
        int[] charCount = new int[26];
        char[] chars = s.toCharArray();
        int length = chars.length;
        while (right < length) {
            char rightChar = chars[right];
            charCount[rightChar - 'A']++;
            historyMaxCount = Math.max(historyMaxCount, charCount[rightChar - 'A']);
            if (right - left + 1 > historyMaxCount + k) {
                charCount[chars[left] - 'A']--;
                left++;
            }
            right++;
        }
        return length - left;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (map.containsKey(val) && i - map.get(val) <= k) {
                return true;
            } else {
                map.put(val, i);
            }
        }
        return false;
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        HashSet<String> set = new HashSet<>();
        int indexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            String val = list2[i];
            if (map1.containsKey(val)) {
                if (indexSum > i + map1.get(val)) {
                    indexSum = i + map1.get(val);
                    set.clear();
                    set.add(val);
                } else if (indexSum == i + map1.get(val)) {
                    set.add(val);
                }
            }
        }
        return set.toArray(new String[0]);
    }

    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int index = map.get(target - nums[i]);
                if (index != i) {
                    return new int[]{i, index};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            n = bitSquareSum(n);
            if (n == 1) {
                System.out.println(set);
                return true;
            }
        }
        return false;
    }

    public static int bitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int tail = n % 10;
            sum += tail * tail;
            n /= 10;
        }
        return sum;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        HashSet<Integer> list = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
            }
        }
        int[] ints = new int[list.size()];
        Iterator<Integer> iterator = list.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            ints[index++] = next;
        }
        return ints;
    }

    public int singleNumber(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int result = nums[0];
        for (int i = 1; i < len; i++) {
            result ^= nums[i];
        }
        return result;
    }
}

