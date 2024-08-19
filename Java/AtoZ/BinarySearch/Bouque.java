package Java.AtoZ.BinarySearch;

import Java.Utility.Helpers;

// Task is to find min no of days so that i can make
// m bouquets each containing k flowers.
// arr[i] contains 1 flower that blooms on the arr[i]th day.

public class Bouque {

    public static int getBouquets(int[] arr, int mid, int m, int k) {
        int tempM = 0;
        int tempK = 0;

        for (int i = 0; i < arr.length; i++) {

            if (mid >= arr[i]) {
                tempK++;
                if (tempK == k) {
                    tempM++;
                    tempK = 0;
                }
            } else
                tempK = 0;
        }

        return tempM;

    }

    public static void minDays(int[] bloomDay, int m, int k) {
        int low = 1, high = Helpers.findMax(bloomDay);
        int ans = -1;

        if ((m * k) > bloomDay.length) {
            System.out.println(ans);
            return;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int totalB = getBouquets(bloomDay, mid, m, k);

            if (totalB >= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        // int[] arr = { 7, 7, 7, 7, 12, 7, 7 };
        int[] arr = { 1, 1, 3, 10, 2 };

        minDays(arr, 1, 2);

    }
}
