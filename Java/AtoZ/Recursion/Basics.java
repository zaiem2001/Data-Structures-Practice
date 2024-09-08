package Java.AtoZ.Recursion;

import java.util.Arrays;

public class Basics {
    public static int[] reverseArr(int[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }

        swap(arr, left, right);
        return reverseArr(arr, left + 1, right - 1);
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void print1ToN(int n) {
        if (n == 0)
            return;

        print1ToN(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        // print1ToN(4);

        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(reverseArr(arr, 0, arr.length - 1)));
    }
}
