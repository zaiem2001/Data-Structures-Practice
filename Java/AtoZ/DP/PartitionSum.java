package Java.AtoZ.DP;

public class PartitionSum {
    static boolean canPart(int[] nums, int i, int target) {
        if (target == 0) {
            return true;
        }

        if (i == 0) {
            return nums[0] == target;
        }

        boolean nonPick = canPart(nums, i - 1, target);
        boolean pick = false;

        if (target >= nums[i]) {
            pick = canPart(nums, i - 1, target - nums[i]);
        }

        return pick || nonPick;
    }

    static boolean helper(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for (int x : nums) {
            sum += x;
        }

        if ((sum & 1) == 1)
            return false;

        sum /= 2;
        // boolean[][] dp = new boolean[n][sum + 1];
        boolean prev[] = new boolean[sum + 1];

        // for (int i = 0; i < n; i++) {
        // dp[i][0] = true;
        // }

        if (nums[0] <= sum)
            prev[nums[0]] = true;

        for (int i = 1; i < n; i++) {
            boolean[] curr = new boolean[sum + 1];
            for (int am = 0; am <= sum; am++) {
                boolean nonPick = prev[am];
                boolean pick = false;

                if (am >= nums[i]) {
                    pick = prev[am - nums[i]];
                }
                curr[am] = pick || nonPick;
            }
            prev = curr;
        }

        return prev[sum];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 11, 5, 4 };

        System.out.println(helper(nums));
    }
}
