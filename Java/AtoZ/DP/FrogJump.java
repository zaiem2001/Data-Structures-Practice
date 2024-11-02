package Java.AtoZ.DP;

import java.util.Arrays;

public class FrogJump {
    static int jump_top(int arr[], int n, int[] dp) {
        if (n == 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        int left = jump_top(arr, n - 1, dp) + Math.abs(arr[n] - arr[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1)
            right = jump_top(arr, n - 2, dp) + Math.abs(arr[n] - arr[n - 2]);

        return dp[n] = Math.min(left, right);
    }

    static int jump_k_times(int n, int k, int[] arr) {
        if (n < 0)
            return 0;

        int jump = 0;
        for (int i = 1; i <= k; i++) {
            if (n >= i) {
                jump = jump_k_times(n - i, k, arr) + Math.abs(arr[n] - arr[n - i]);
            }
        }

        return jump;
    }

    static int jump_bottom(int[] arr, int n) {
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int left = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int right = Integer.MAX_VALUE;

            if (i > 1)
                right = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);

            dp[i] = Math.min(left, right);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 10, 10 };
        int[] dp = new int[arr.length];
        System.out.println(jump_bottom(arr, arr.length));
        Arrays.fill(dp, -1);

        System.out.println(jump_top(arr, arr.length - 1, dp));
        System.out.println(jump_k_times(arr.length - 1, 100, arr));
    }

}