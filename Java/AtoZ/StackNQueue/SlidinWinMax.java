package Java.AtoZ.StackNQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidinWinMax {
    static int getMax(int nums[]) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }
        return max;
    }

    static int[] maxSlidingWind(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int n = nums.length;

        if (k == n) {
            return new int[] { getMax(nums) };
        }

        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.getFirst() <= i - k) {
                q.removeFirst();
            }
            while (!q.isEmpty() && nums[i] >= nums[q.getLast()]) {
                q.removeLast();
            }

            q.addLast(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[q.getFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7, 10, 13, 14, 2 };
        System.out.println(Arrays.toString(maxSlidingWind(nums, 9)));
    }
}
