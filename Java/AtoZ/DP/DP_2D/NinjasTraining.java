package Java.AtoZ.DP.DP_2D;

import java.util.Arrays;

public class NinjasTraining {
    static int solve(int start, int lastActivity, int[][] arr, int[][] dp) {
        int n = arr.length;

        if (n == start)
            return 0;

        int[] currentDay = arr[start];
        int maxPoints = 0;

        if (dp[start][lastActivity] != 0)
            return dp[start][lastActivity];

        for (int i = 0; i < 3; i++) {
            if (i != lastActivity) {
                int points = currentDay[i] + solve(start + 1, i, arr, dp);
                maxPoints = Math.max(maxPoints, points);
            }
        }

        return dp[start][lastActivity] = maxPoints;
    }

    static int getMaxPoints(int[][] arr, int n) {
        // boolean[] done = new boolean[3];
        int[][] dp = new int[arr.length][4];

        int p = solve(0, 3, arr, dp);
        System.out.println(Arrays.deepToString(dp));
        return p;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
        int n = arr.length;

        System.out.println(getMaxPoints(arr, n));
    }
}
