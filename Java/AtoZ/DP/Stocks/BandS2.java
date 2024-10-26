package Java.AtoZ.DP.Stocks;

import java.util.Arrays;

public class BandS2 {
    static int solve(int day, int canBuy, int[] prices, int fee) {
        if (day >= prices.length)
            return 0;

        int profit = 0;

        if (canBuy == 1) {
            profit = Math.max((-prices[day]) + solve(day + 1, 0, prices, fee), solve(day + 1, 1, prices, fee));
        } else {
            profit = Math.max((prices[day] - fee) + solve(day + 1, 1, prices, fee), solve(day + 1, 0, prices, fee));
        }

        return profit;
    }

    static int maxProfitWithTxnFee(int[] prices, int fee) {
        return solve(0, 1, prices, fee);
    }

    static int maxProfit(int[] nums, int canBuy, int i, int[][] dp) {
        if (i == nums.length)
            return 0;

        if (dp[i][canBuy] != 0)
            return dp[i][canBuy];

        int profit = 0;
        if (canBuy == 1) {
            profit = Math.max((-nums[i]) + maxProfit(nums, 0, i + 1, dp), maxProfit(nums, 1, i + 1, dp));
        } else {
            profit = Math.max(nums[i] + maxProfit(nums, 1, i + 1, dp), maxProfit(nums, 0, i + 1, dp));
        }

        return dp[i][canBuy] = profit;
    }

    static int maxProfit_coolDown(int[] nums, int i, int canBuy) {
        if (i >= nums.length)
            return 0;

        int profit = 0;
        if (canBuy == 1) {
            profit = Math.max((-nums[i]) + maxProfit_coolDown(nums, i + 1, 0), maxProfit_coolDown(nums, i + 1, 1));
        } else {
            profit = Math.max(nums[i] + maxProfit_coolDown(nums, i + 2, 1), maxProfit_coolDown(nums, i + 1, 0));
        }

        return profit;
    }

    static int maxProfit_atMost2(int[] nums, int canBuy, int i, int txns) {
        if (i == nums.length)
            return 0;

        if (txns == 0)
            return 0;

        int profit = 0;
        if (canBuy == 1) {
            profit = Math.max((-nums[i]) + maxProfit_atMost2(nums, 0, i + 1, txns),
                    maxProfit_atMost2(nums, 1, i + 1, txns));
        } else {
            profit = Math.max(nums[i] + maxProfit_atMost2(nums, 1, i + 1, txns - 1),
                    maxProfit_atMost2(nums, 0, i + 1, txns));
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int n = nums.length;
        // int dp[][] = new int[n + 1][2];

        // tabulation
        // dp[n][0] = dp[n][1] = 0;
        int[] ahead = new int[n + 1];
        int[] curr = new int[n + 1];
        ahead[n] = curr[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                int profit = 0;
                if (canBuy == 1) {
                    profit = Math.max((-nums[i]) + ahead[0], ahead[1]);
                } else {
                    profit = Math.max(nums[i] + ahead[1], ahead[0]);
                }
                curr[canBuy] = profit;
            }
            ahead = curr;
        }

        System.out.println(Arrays.toString(ahead));
        System.out.println(ahead[1]);
        // System.out.println(maxProfit(nums, 1, 0, dp));

        System.out.println("COOL DOWN:");
        System.out.println(maxProfit_coolDown(nums, 0, 1));

        System.out.println("At most 2: ");
        System.out.println(maxProfit_atMost2(nums, 1, 0, 2));

        System.out.println(maxProfit_coolDown(nums, 0, 1));

        System.out.println("With Txn fee.");
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        int fee = 2;
        System.out.println(maxProfitWithTxnFee(prices, fee));
        int p = prices.length;

        int[][] txnDP = new int[p + 1][2];
        // txnDP[p - 1][0] = 0;
        // txnDP[p - 1][1] = -prices[p - 1];

        for (int i = p - 1; i >= 0; i--) {
            txnDP[i][1] = Math.max((-prices[i]) + txnDP[i + 1][0], txnDP[i + 1][1]);
            txnDP[i][0] = Math.max((prices[i] - fee) + txnDP[i + 1][1], txnDP[i + 1][0]);
        }

        System.out.println(txnDP[0][1]);
        System.out.println(Arrays.deepToString(txnDP));
    }
}
