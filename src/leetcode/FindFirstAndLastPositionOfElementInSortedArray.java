package leetcode;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[] {5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[] {5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[] {}, 0)));
        System.out.println(Arrays.toString(searchRange(new int[] {1}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[] {2, 2}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[] {1, 3}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[] {-99999,-99998,-9999,-999,-99,-9,-1}, 0)));
        System.out.println(Arrays.toString(searchRange(new int[]{0, 1, 2, 3, 4, 4, 4}, 2)));

    }
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length == 0) return res;
        if(nums.length == 1) return target == nums[0] ? new int[]{0, 0} : res;

        findPlaces(res, nums, target, 0, nums.length - 1, nums.length / 2);

        return res;
    }

    private static void findPlaces(int[] res, int[] nums, int target, int start, int end, int pivot) {
        if(nums[pivot] == target) {
            checkBoundary(res, nums, target, pivot);
        }
        else if (pivot == 1 || pivot == end) {
            if(nums[start] == target) {
                checkBoundary(res, nums, target, start);
            } else if(nums[end] == target) {
                checkBoundary(res, nums, target, end);
            } else return;
        } else if(target > nums[pivot]) {
            int endPivot = ((end - pivot) / 2) + pivot + 1;
            findPlaces(res, nums, target, pivot, end, endPivot);
        } else if(target < nums[pivot]) {
            findPlaces(res, nums, target, start, pivot - 1, pivot / 2);
        }
    }

    private static void checkBoundary(int[] res, int[] nums, int target, int position) {
        int i=position, j=position;
        while (i - 1 > -1 && nums[i - 1] == target) {
            i--;
        }
        while (j + 1 < nums.length && nums[j + 1] == target) {
            j++;
        }
        res[0] = i; res[1] = j;
    }
}
