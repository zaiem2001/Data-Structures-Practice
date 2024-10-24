package Java.AtoZ.DP.DP_2D;

import java.util.Arrays;

public class UniquePaths {
    static int count = 0;

    static int solve(int row, int col, int[][] dp) {
        if (row == 0 && col == 0)
            return 1;

        if (row < 0 || col < 0)
            return 0;

        if (dp[row][col] != 0)
            return dp[row][col];

        count++;

        // || visited[row][col] == 1
        // visited[row][col] = 1;

        int left = solve(row - 1, col, dp);
        int right = solve(row, col - 1, dp);
        // visited[row][col] = 0;

        return dp[row][col] = left + right;
    }

    static int findPaths(int m, int n) {
        int[][] dp = new int[m][n];

        return solve(m - 1, n - 1, dp);
    }

    public static void main(String[] args) {
        int m = 3, n = 7;

        System.out.println(findPaths(m, n));
        System.out.println("Count");
        System.out.println(count);

        int[][] dp = new int[m][n];

        for (int row = 0; row < m; row++) {
            dp[row][0] = 1;
        }

        for (int col = 0; col < n; col++) {
            dp[0][col] = 1;
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                // int left = dp[row - 1][col];
                // int right = dp[row][col - 1];
                // dp[row][col] = left + right;
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }

        System.out.println(Arrays.deepToString(dp));

        System.out.println("Tabulation");
        System.out.println(dp[m - 1][n - 1]);
    }
}
