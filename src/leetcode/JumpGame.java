package leetcode;

public class JumpGame {
    public static void main(String[] args) {
//        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
//        System.out.println(canJump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        int i = 0;

        for (int reach = 0; i < nums.length && i <= reach; ++i) {
            reach = Math.max(reach, i + nums[i]);
        }

        return i == nums.length;
    }
}
