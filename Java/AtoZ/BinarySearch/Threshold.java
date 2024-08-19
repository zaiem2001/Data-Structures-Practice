package Java.AtoZ.BinarySearch;

import Java.Utility.Helpers;

public class Threshold {
    public static int getDivisor(int[] nums, int mid) {
        double total = 0;

        for (int x : nums) {
            total += Math.ceilDiv((long) x, (long) mid);
        }

        return (int) total;
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Helpers.findMax(nums);

        while (low <= high) {
            int mid = (low + high) / 2;
            int total = getDivisor(nums, mid);

            // System.out.println(total + "-> " + mid);

            if (total <= threshold) {
                high = mid - 1;
            } else if (total > threshold) {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = { 21212, 10101, 12121 };
        System.out.println(smallestDivisor(arr, 1000000));

    }
}