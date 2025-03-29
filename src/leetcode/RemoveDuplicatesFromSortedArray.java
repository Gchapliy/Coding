package leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] test1 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] test2 = new int[]{1, 1, 2};
        System.out.printf("%s res: %s\n", Arrays.toString(test1), removeDuplicates(test1));
        System.out.printf("%s res: %s\n", Arrays.toString(test2), removeDuplicates(test2));
    }

    public static int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
