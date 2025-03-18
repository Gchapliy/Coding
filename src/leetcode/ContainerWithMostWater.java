package leetcode;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int min = Math.min(height[l], height[r]);
            max = Math.max(max, min * (r - l));
            if(height[l] < height[r]) {
                ++l;
            } else {
                --r;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,1}));
        System.out.println(maxArea(new int[]{1,0,0,0,0,0,0,2,2}));
        System.out.println(maxArea(new int[]{0, 2}));
        System.out.println(maxArea(new int[]{2, 0}));
    }
}
