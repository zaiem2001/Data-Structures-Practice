package Java.AtoZ.Arrays;

import java.util.Arrays;

public class SortColors {
    private static void swap(int[] arr, int i, int k) {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }

    public static void sortColrs(int[] arr) {
        int low = 0, high = arr.length - 1, mid = 0;

        while (mid <= high) {
            int elem = arr[mid];

            if (elem == 0) {
                swap(arr, mid, low);
                mid++;
                low++;

            } else if (elem == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
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
