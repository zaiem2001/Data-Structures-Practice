package Java.AtoZ.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static int sumN(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void helper(int start, int k, int n, List<Integer> ds, List<List<Integer>> result) {
        if (k < 0 || n < 0)
            return;

        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(ds));
        }

        for (int i = start; i <= 9; i++) {
            if (i > n)
                continue;

            ds.add(i);
            helper(i + 1, k - 1, n - i, ds, result);
            ds.remove(ds.size() - 1);
        }

    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (sumN(k) > n)
            return result;

        helper(1, k, n, new ArrayList<>(), result);

        return result;
    }

    public static void main(String[] args) {
        int k = 3, n = 8;
        System.out.println(combinationSum3(k, n));
    }
}
