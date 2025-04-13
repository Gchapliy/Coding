package leetcode;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5})); // 9
        System.out.println(trap(new int[]{4, 2, 3})); // 1
    }

    public static int trap(int[] height) {
        int left = -1, right, res = 0;

        int idx = 0;

        while (idx < height.length) {
            int current = height[idx];

            if(left > -1 && current >= height[left]) {
                right = idx;
                int leftVal = height[left];
                left++;
                while (left < right) {
                    res += Math.abs(leftVal - height[left]);
                    left++;
                }
                left = idx;
                fixHeight(height, left);
            } else if(current > 0 && left == -1) {
                left = idx;
                fixHeight(height, left);
            }
            idx++;
        }

        return res;
    }

    private static void fixHeight(int[] height, int idx) {
        int currentVal = height[idx];
        int curIdx = idx;
        int nextMax = 0;

        idx++;
        while (idx < height.length) {
            if(height[idx] >= currentVal) return;
            if(height[idx] > nextMax) {
                nextMax = height[idx];
            }
            idx++;
        }

        height[curIdx] = nextMax;
    }
}
