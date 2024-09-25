package Java.AtoZ.DP;

import java.util.Arrays;

public class HouseRobber {
    static int rob(int[] nums) {
        int n = nums.length;
        int maxLoot = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int looted = nums[i];
            for (int j = i + 2; j < n; j += 2) {
                looted += nums[j];
            }
            maxLoot = Math.max(maxLoot, looted);
        }

        return maxLoot;
    }

    static int rob_rec(int[] nums, int indx, int[] dp) {
        if (indx == 0)
            return nums[indx];
        if (indx < 0)
            return 0;

        if (dp[indx] != -1)
            return dp[indx];

        int pick = nums[indx] + rob_rec(nums, indx - 2, dp);
        int nonPick = 0 + rob_rec(nums, indx - 1, dp);

        return dp[indx] = Math.max(pick, nonPick);
    }

    public static void main(String[] args) {
        int nums[] = { 2, 7, 9, 3, 1 };
        // int nums[] = { 1, 2, 3, 1 };
        // System.out.println(rob_rec(nums));
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        System.out.println(rob_rec(nums, nums.length - 1, dp));

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i];
            if (i > 1)
                pick += dp[i - 2];
            int nonPick = 0 + dp[i - 1];
            dp[i] = Math.max(pick, nonPick);
        }
        System.out.println(dp[nums.length - 1]);

    }
}
