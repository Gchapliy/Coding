package leetcode;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int res = 0;
        int i = 0, j = nums.length - 1;

        while (i <= j) {
            if (nums[i] == val) {
                while (j > i) {
                    if (nums[j] != val) {
                        nums[i] = nums[j];
                        j--;
                        res++;
                        break;
                    }
                    j--;
                }
            } else {
                res++;
            }
            i++;
        }

        System.out.println(Arrays.toString(nums));

        return res;
    }
}
