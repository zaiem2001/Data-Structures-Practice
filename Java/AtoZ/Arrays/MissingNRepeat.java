package Java.AtoZ.Arrays;

import java.util.Arrays;

public class MissingNRepeat {
    public static void findTwoElements(int[] arr, int n) {
        long Sn = (n * (n + 1)) / 2;
        long S = 0;

        long S2n = (n * (n + 1) * (2 * n + 1)) / 6;
        long S2 = 0;

        for (int i = 0; i < n; i++) {
            S += arr[i];
            S2 += arr[i] * arr[i];
        }

        long value1 = S - Sn;
        long value2 = S2 - S2n;
        value2 = value2 / value1;

        long x = (value1 + value2) / 2;
        long y = x - value1;

        int[] answer = { (int) x, (int) y };
        System.out.println(Arrays.toString(answer));

    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = { 1, 1, 2, 3, 5 };
        findTwoElements(arr, n);
    }
}
