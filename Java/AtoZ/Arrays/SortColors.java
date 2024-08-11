package Java.AtoZ.Arrays;

import java.util.Arrays;

import Java.Utility.Helpers;

public class SortColors {
    public static void sortColrs(int[] arr) {
        int low = 0, high = arr.length - 1, mid = 0;

        while (mid <= high) {
            int elem = arr[mid];

            if (elem == 0) {
                Helpers.swap(arr, mid, low);
                mid++;
                low++;

            } else if (elem == 1) {
                mid++;
            } else {
                Helpers.swap(arr, mid, high);
                high--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 0 };
        sortColrs(arr);
    }

}
