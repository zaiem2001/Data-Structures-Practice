package Java.AtoZ.DP;

import java.util.Arrays;

public class CoinChange {
    static int coinChange(int[] coins, int amount, int idx, int[][] dp) {
        if (amount == 0)
            return 0;
        if (idx == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];
            return Integer.MAX_VALUE;
        }

        if (dp[idx][amount] != 0)
            return dp[idx][amount];

        int notPick = coinChange(coins, amount, idx - 1, dp);
        int pick = Integer.MAX_VALUE;

        if (amount >= coins[idx]) {
            int res = coinChange(coins, amount - coins[idx], idx, dp);
            if (res != Integer.MAX_VALUE) {
                pick = 1 + res;
            }
        }

        dp[idx][amount] = Math.min(pick, notPick);

        return dp[idx][amount];
    }

    static int change(int amount, int[] coins, int idx, int[][] dp) {
        if (amount == 0)
            return 1;
        if (idx == 0) {
            if (amount % coins[0] == 0)
                return 1;
            return 0;
        }

        if (dp[idx][amount] != 0) {
            return dp[idx][amount];
        }

        int notPick = change(amount, coins, idx - 1, dp);
        int pick = 0;
        if (amount >= coins[idx]) {
            pick = change(amount - coins[idx], coins, idx, dp);
        }

        return dp[idx][amount] = pick + notPick;
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        int dp[][] = new int[coins.length][amount + 1];
        int[] prev = new int[amount + 1];

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                prev[i] = i / coins[0];
            else
                prev[i] = Integer.MAX_VALUE - 1;
        }

        // for (int i = 0; i < coins.length; i++) {
        // dp[i][0] = 0;
        // }

        // for (int i = 0; i <= amount; i++) {
        // if (i % coins[0] == 0)
        // dp[0][i] = i / coins[0];
        // else
        // dp[0][i] = Integer.MAX_VALUE - 1;
        // }

        for (int i = 1; i < coins.length; i++) {
            int[] curr = new int[amount + 1];
            for (int a = 0; a <= amount; a++) {
                int notPick = prev[a];
                int pick = Integer.MAX_VALUE;

                if (a >= coins[i]) {
                    pick = curr[a - coins[i]] + 1;
                }
                curr[a] = Math.min(notPick, pick);
            }
            prev = curr;
        }

        System.out.println("RESULT--> " + prev[amount]);

        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        int result = coinChange(coins, amount, coins.length - 1, dp);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

        int coins2[] = { 1, 2, 5 };
        int amount2 = 5;
        int[][] dp2 = new int[coins2.length][amount2 + 1];
        System.out.println(change(amount2, coins2, coins2.length - 1, dp2));

        int[] dp3 = new int[amount2 + 1];
        dp3[0] = 1; // There's 1 way to make the amount 0

        for (int coin : coins2) {
            for (int i = coin; i <= amount2; i++) {
                dp3[i] += dp3[i - coin];
            }
        }

        System.out.println(Arrays.toString(dp3));
        System.out.println(dp3[amount2]);

    }

}