package leetcode;

public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0})); // 3
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1})); // 2
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12})); // 1
        System.out.println(firstMissingPositive(new int[]{100000, 3, 4000, 2, 15, 1, 99999})); // 4
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
