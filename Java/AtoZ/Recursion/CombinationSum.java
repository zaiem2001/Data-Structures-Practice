package Java.AtoZ.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void helper(int[] candidates, int target, int idx, int n, List<List<Integer>> result,
            List<Integer> ds) {

        if (idx == n) {
            if (target == 0) {
                result.add(new ArrayList<>(ds));
            }
            return;
        }

        int curr = candidates[idx];

        if (curr <= target) {
            ds.add(curr);
            helper(candidates, target - curr, idx, n, result, ds);
            ds.remove(ds.size() - 1);
        }

        helper(candidates, target, idx + 1, n, result, ds);
        return;
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int idx = 0;
        int n = candidates.length;

        helper(candidates, target, idx, n, result, ds);

        return result;
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
}
