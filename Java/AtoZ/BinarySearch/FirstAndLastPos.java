package Java.AtoZ.BinarySearch;

import java.util.Arrays;

public class FirstAndLastPos {
    // Lower bound = arr[i] >= target
    // Upper bound = arr[i] > target

    public static int lowerAndUpperBounds(int[] arr, int target, boolean isLower) {
        int result = arr.length;
        int low = 0, high = arr.length - 1;
        int mid;
        boolean condition;

        while (low <= high) {
            mid = (low + high) / 2;
            condition = isLower ? arr[mid] >= target : arr[mid] > target;

            if (condition) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static int[] searchRange(int[] arr, int target) {
        int lb = lowerAndUpperBounds(arr, target, true);

        if (lb == arr.length || arr[lb] != target)
            return new int[] { -1, -1 };

        return new int[] { lb, lowerAndUpperBounds(arr, target, false) - 1 };
    }

    public static void main(String[] args) {
        int[] arr = {};
        int target = 0;

        System.out.println(Arrays.toString(searchRange(arr, target)));

    }
}
