package leetcode;

import java.util.Arrays;

public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4})); //[-2,1,-3,4,-1,2,1,-5,4]
        System.out.println(maxSubArray(new int[] {1})); //[1]
        System.out.println(maxSubArray(new int[] {5,4,-1,7,8})); //[5,4,-1,7,8]
    }
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);

        return Arrays.stream(dp).max().getAsInt();
    }
}
