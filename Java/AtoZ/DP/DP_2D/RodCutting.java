package Java.AtoZ.DP.DP_2D;

import java.util.Arrays;

public class RodCutting {
    static int solve(int[] price, int length, int indx, Integer[][] dp) {
        if (length <= 0)
            return 0;

        if (indx == 0)
            return length * price[0];

        if (dp[indx][length] != null)
            return dp[indx][length];

        int notCut = solve(price, length, indx - 1, dp);
        int cut = Integer.MIN_VALUE;

        if (length - 1 >= indx) {
            cut = price[indx] + solve(price, length - (indx + 1), indx, dp);
        }

        return dp[indx][length] = Math.max(notCut, cut);
    }

    static int cutRod(int[] price, int n) {
        Integer[][] dp = new Integer[n][n + 1];

        int ans = solve(price, n, n - 1, dp);

        System.out.println(Arrays.deepToString(dp));
        return ans;
    }

    public static void main(String[] args) {
        int n = 8;
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };

        System.out.println(cutRod(price, n));

        int[][] dp = new int[n][n + 1];
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        // for (int i = 0; i < n; i++) {
        // dp[i][0] = 0;
        // }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i * price[0];
            prev[i] = i * price[0];
        }

        for (int row = 1; row < n; row++) {
            for (int col = 1; col <= n; col++) {
                int notPick = prev[col];
                int pick = Integer.MIN_VALUE;

                if (col - 1 >= row) {
                    pick = price[row] + curr[col - (row + 1)];
                }

                curr[col] = Math.max(notPick, pick);
            }

            prev = curr;
        }

        System.out.println(Arrays.deepToString(dp));
        System.out.println(Arrays.toString(prev));
        System.out.println(Arrays.toString(curr));
    }
}
