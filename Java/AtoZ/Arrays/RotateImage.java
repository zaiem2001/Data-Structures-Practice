package Java.AtoZ.Arrays;

import java.util.Arrays;

import Java.Utility.Helpers;

public class RotateImage {
    public static void rotate(int[][] arr) {
        int n = arr.length;

        // Step 1. Transpose the matrix
        transpose(arr, n);

        // Step 2. Reverse each row.
        for (int i = 0; i < n; i++) {
            Helpers.reverse(arr[i], 0, arr[i].length - 1);
        }
        System.out.println(Arrays.deepToString(arr));
    }

    private static void transpose(int[][] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotate(arr);
    }
}
