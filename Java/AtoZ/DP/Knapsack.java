package Java.AtoZ.DP;

import java.util.Arrays;

public class Knapsack {
    // we can pick item with value v and weight w, n times.
    // given that weight[i] <= totalWeight
    static int unbounded(int[] wt, int[] val, int[][] dp, int i, int w) {
        if (w == 0) {
            return 0;
        }

        if (i == 0) {
            if (w >= wt[0])
                return (w / wt[0]) * val[0];
            else
                return 0;
        }

        if (dp[i][w] != 0)
            return dp[i][w];

        int notPick = unbounded(wt, val, dp, i - 1, w);
        int pick = 0;

        if (w >= wt[i]) {
            pick = val[i] + unbounded(wt, val, dp, i, w - wt[i]);
        }

        return dp[i][w] = Math.max(pick, notPick);
    }

    public static void main(String[] args) {
        int[] wt = { 1, 3, 4, 5 };
        int[] val = { 6, 1, 7, 7 };
        int n = val.length;
        int weight = 8;
        int[][] dp = new int[n][weight + 1];
        int[] prev = new int[weight + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= weight; i++) {
            if (i >= wt[0]) {
                dp[0][i] = (i / wt[0]) * val[0];
                prev[i] = (i / wt[0]) * val[0];
            } else {
                dp[0][i] = 0;
                prev[i] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[weight + 1];
            for (int w = 0; w <= weight; w++) {
                int notPick = prev[w];
                // int notPick = dp[i - 1][w];
                int pick = 0;
                if (w >= wt[i]) {
                    pick = val[i] + curr[w - wt[i]];
                }

                curr[w] = Math.max(pick, notPick);
            }
            prev = curr;
        }

        System.out.println(Arrays.toString(prev));
        System.out.println(prev[weight]);
        System.out.println(unbounded(wt, val, dp, n - 1, weight));

    }
}
