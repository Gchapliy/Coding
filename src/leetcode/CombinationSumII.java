package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8)); //[[1,1,6],[1,2,5],[1,7],[2,6]]
        System.out.println(combinationSum(new int[]{2, 5, 2, 1, 2}, 5)); //[[1,2,2],[5]]
        System.out.println(combinationSum(new int[]{2}, 1)); //[]
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        makeCombination(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    private static void makeCombination(int[] candidates, int target, int idx, List<Integer> comb, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(comb));
        }

        for (int i = idx; i < candidates.length; i++) {
            if(i > idx && candidates[i] == candidates[i - 1])
                continue;
            comb.add(candidates[i]);
            makeCombination(candidates, target - candidates[i], i + 1, comb, res);
            comb.removeLast();
        }
    }
}
