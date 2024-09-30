package Java.AtoZ.DP.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncSubs {
    static int lengthOfLIS_optimal(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int position = bSearch(sub, nums[i]);

            if (position == sub.size())
                sub.add(nums[i]);
            else
                sub.set(position, nums[i]);
        }

        System.out.println(sub);
        return sub.size();
    }

    private static int bSearch(ArrayList<Integer> nums, int target) {
        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums.get(mid) == target)
                return mid;
            else if (nums.get(mid) < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }

    static int lengthOfLIS(int[] nums, int n, int prevIndx) {
        if (n < 0) {
            return 0;
        }

        int notPick = lengthOfLIS(nums, n - 1, prevIndx);

        int pick = 0;
        if (prevIndx == -1 || nums[n] < nums[prevIndx]) {
            pick = 1 + lengthOfLIS(nums, n - 1, n);
        }

        return Math.max(notPick, pick);
    }

    static int lengthOfLIS_print(int[] nums) {
        int count = 1;
        int last_index = 0;
        int[] dp = new int[nums.length];
        int[] hash = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
                if (dp[i] > count) {
                    count = dp[i];
                    last_index = i;
                }
            }
        }

        List<Integer> output = new ArrayList<>();
        output.add(nums[last_index]);

        while (hash[last_index] != last_index) {
            last_index = hash[last_index];
            output.add(nums[last_index]);
        }

        System.out.println("OUTPUT: -> " + output.reversed());
        System.out.println(Arrays.toString(dp));
        return count;
    }

    static int lengthOfLIS_divisible(int[] nums) {
        int count = 1;
        int last_index = 0;
        int[] dp = new int[nums.length];
        int[] hash = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] == 0 && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
                if (dp[i] > count) {
                    count = dp[i];
                    last_index = i;
                }
            }
        }

        List<Integer> output = new ArrayList<>();
        output.add(nums[last_index]);

        while (hash[last_index] != last_index) {
            last_index = hash[last_index];
            output.add(nums[last_index]);
        }

        System.out.println("OUTPUT: -> " + output.reversed());
        System.out.println(Arrays.toString(dp));
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, 8, 7, 16, 2 };
        // int n = nums.length;

        // System.out.println(lengthOfLIS(nums, n - 1, -1));
        // System.out.println(lengthOfLIS_optimal(nums));
        // System.out.println(lengthOfLIS_print(nums));
        System.out.println(lengthOfLIS_divisible(nums));

    }
}
