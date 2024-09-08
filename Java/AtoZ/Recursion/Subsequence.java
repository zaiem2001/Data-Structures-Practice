package Java.AtoZ.Recursion;

import java.util.ArrayList;

public class Subsequence {
    public static int countSubsequenceWithSumK(int n, int i, int sum, int k, int[] arr) {
        if (i == n) {
            if (sum == k)
                return 1;
            return 0;
        }

        sum += arr[i];
        int l = countSubsequenceWithSumK(n, i + 1, sum, k, arr);

        sum -= arr[i];
        int r = countSubsequenceWithSumK(n, i + 1, sum, k, arr);

        return l + r;
    }

    public static void printSubsequence(int n, ArrayList<Integer> ds, int[] arr, int indx) {
        if (indx == n) {
            System.out.println(ds);
            return;
        }

        ds.add(arr[indx]);
        // Deciding to take the index.
        printSubsequence(n, ds, arr, indx + 1);

        ds.removeLast();
        // Deciding to not take the index
        printSubsequence(n, ds, arr, indx + 1);
        return;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        ArrayList<Integer> ds = new ArrayList<>();
        printSubsequence(arr.length, ds, arr, 0);
        System.out.println(countSubsequenceWithSumK(arr.length, 0, 0, 6, arr));
    }
}