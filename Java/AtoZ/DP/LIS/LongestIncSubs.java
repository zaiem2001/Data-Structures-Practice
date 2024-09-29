package Java.AtoZ.DP.LIS;

import java.util.ArrayList;

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

    public static void main(String[] args) {
        int[] nums = { 2, 1, 5, 0, 4, 6 };
        // int n = nums.length;

        // System.out.println(lengthOfLIS(nums, n - 1, -1));
        System.out.println(lengthOfLIS_optimal(nums));

    }
}
