package leetcode;

import java.util.Arrays;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(search(new int[]{1}, 0));
        System.out.println(search(new int[]{1}, 1));
    }
    public static int search(int[] nums, int target) {

        int lnth= nums.length, i=1, j=lnth - 1, pivot = 0, res = -1;

        while (i <= lnth /2 && j >= lnth /2) {
            if(nums[i] < nums[i-1]) {
                pivot = i;
                break;
            }
            if(nums[j - 1] > nums[j]) {
                pivot = j;
                break;
            }
            i++;j--;
        }

            res = Arrays.binarySearch(nums, 0, pivot, target);
            if(res == -1) {
                res = Arrays.binarySearch(nums, pivot, lnth, target);
            }

        return Math.max(res, -1);
    }
}
