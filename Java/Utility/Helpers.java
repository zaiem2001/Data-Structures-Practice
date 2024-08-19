package Java.Utility;

public class Helpers {
    public static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int x : arr) {
            max = Math.max(x, max);
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int x : arr) {
            min = Math.min(x, min);
        }
        return min;
    }
}
