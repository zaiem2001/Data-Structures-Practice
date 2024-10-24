package Java.AtoZ.DP;

import java.util.Arrays;

public class SubsetSum {
    static Boolean isSubset(int n, int arr[], int target, int[][] dp) {
        if (target == 0)
            return true;
        if (n == 0)
            return arr[0] == target;

        if (dp[n][target] != -1)
            return dp[n][target] == 1;

        boolean nonPick = isSubset(n - 1, arr, target, dp);

        boolean pick = false;
        if (arr[n] <= target) {
            pick = isSubset(n - 1, arr, target - arr[n], dp);

        }

        dp[n][target] = pick || nonPick ? 1 : 0;

        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[n][target]);
        return dp[n][target] == 1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 34, 4, 12, 5, 2 };
        int n = arr.length;
        int target = 9;
        int[][] dp = new int[n][target + 1];

        boolean[][] tab = new boolean[n][target + 1];
        int[][] tab2 = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            tab[i][0] = true;
            tab2[i][0] = 0;
        }

        if (arr[0] <= target) {
            tab[0][arr[0]] = true;
            tab2[0][arr[0]] = arr[0];
        }

        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= target; t++) {
                boolean notTake = tab[i - 1][t];
                int notTake2 = tab2[i - 1][t];
                int take2 = -1;

                boolean take = false;
                if (arr[i] <= t) {
                    take = tab[i - 1][t - arr[i]];
                    take2 = tab2[i - 1][t - arr[i]];
                    if (take2 != -1)
                        take2 += arr[i];
                }
                tab[i][t] = notTake || take;
                tab2[i][t] = Math.max(notTake2, take2);
            }
        }

        System.out.println(Arrays.deepToString(tab));
        System.out.println(Arrays.deepToString(tab2));
        System.out.println(tab[n - 1][target]);

        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        // System.out.println(isSubset(n - 1, arr, target, dp));
    }
}
