package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        dfs(nums, new boolean[nums.length], new ArrayList<>(), ans);

        return ans;
    }

    private static void dfs(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, used, path, ans);
            path.removeLast();
            used[i] = false;
        }
    }
}
