package Java.AtoZ.BinarySearch;

import Java.Utility.Helpers;

public class Koko {

    public static int findTotalHrs(int[] piles, int h) {
        double totalHrs = 0;

        for (int i = 0; i < piles.length; i++) {
            // totalHrs += ((double) piles[i] / (double) h) + ((piles[i] / h) % 2);
            totalHrs += Math.ceilDiv((long) piles[i], (long) h);
        }

        return (int) totalHrs;
    }

    public static void minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Helpers.findMax(piles);

        while (low <= high) {
            int mid = (low + high) / 2;
            int hours = findTotalHrs(piles, mid);

            if (hours <= h) {
                high = mid - 1;
            } else
                low = mid + 1;
        }

        System.out.println(low);
    }

    public static void main(String[] args) {
        // int[] arr = { 30, 11, 23, 4, 20 };
        int[] arr = { 805306368, 805306368, 805306368 };
        int h = 1000000000;
        minEatingSpeed(arr, h);
    }
}
