package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mem = new HashMap<>(nums.length / 2);

        int first;
        for (int i = 0; i < nums.length; i++) {
            first = target - nums[i];

            Integer prob = mem.get(first);

            if(prob == null) {
                mem.put(nums[i], i);
            } else {
                return new int[]{i, prob};
            }
        }

        return new int[]{0,0};
    }
}
