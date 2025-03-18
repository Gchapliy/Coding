package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IVSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> fourLets = new ArrayList<>();
        for (int i = 0; i < nums.length-3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicate `i`

            for(int j=i+1; j<nums.length-2; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicate `j`
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> fourLet = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        fourLets.add(fourLet);
                        left++;
                        right--;
                        // Skip duplicates for `left` and `right` after moving them
                        while (left < right && nums[left] == nums[left - 1]){
                            left++;
                        }
                        while (left < right && right + 1 < nums.length && nums[right] == nums[right + 1]){
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    }
                }
            }

        }
        return fourLets;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSum(new int[]{2, 2, 2, 2, 2}, 8));
    }
}
