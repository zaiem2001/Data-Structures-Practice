package Java.AtoZ.Arrays;

import java.util.Arrays;

import Java.Utility.Helpers;

public class NextPermutation {
    public static void findNextPer(int[] arr) {
        // 1. find the breakpoint.
        int breakpoint = -1;
        int length = arr.length;

        for (int i = length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                breakpoint = i;
                break;
            }
        }

        // if the breakpoint is -1 then the next permutation is reverse.
        if (breakpoint == -1) {
            // reverse(arr, 0, length - 1);
            Helpers.reverse(arr, 0, length - 1);
            System.out.println(Arrays.toString(arr));
            return;
        }

        // 2. find the next largest element than breakpoint from the end.
        for (int i = length - 1; i > breakpoint; i--) {
            if (arr[i] > arr[breakpoint]) {
                int temp = arr[i];
                arr[i] = arr[breakpoint];
                arr[breakpoint] = temp;
                break;
            }
        }

        Helpers.reverse(arr, breakpoint + 1, length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2 };
        findNextPer(arr);
    }
}
