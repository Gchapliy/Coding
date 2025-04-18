package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 2, 3})); //[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]
        System.out.println(permuteUnique(new int[]{1, 1, 2})); //[1,1,2],[1,2,1],[2,1,1]
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();

        dfs(nums, new boolean[nums.length], new ArrayList<>(), ans);

        return ans.stream().toList();
    }

    private static void dfs(int[] nums, boolean[] used, List<Integer> path, Set<List<Integer>> ans) {
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
