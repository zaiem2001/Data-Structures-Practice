package Java.AtoZ.Arrays;

import java.util.ArrayList;

public class Union {
    public static void findUnion(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> output = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                if (output.size() == 0 || output.getLast() != arr1[i]) {
                    output.add(arr1[i]);

                } else {
                    if (output.size() == 0 || output.getLast() != arr2[j]) {
                        output.add(arr2[j]);
                    }
                }
            }
            i++;
            j++;

        }

        while (i < n) {
            if (output.size() == 1 || output.getLast() != arr1[i]) {
                output.add(arr1[i]);
                i++;
            }
        }

        while (j < m) {
            if (output.size() == 1 || output.getLast() != arr2[i]) {
                output.add(arr2[j]);
                j++;
            }

        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = { 2, 2, 3, 4, 5 };
        int m = 5;
        int[] arr2 = { 1, 1, 2, 3, 4 };

        findUnion(arr1, arr2, n, m);

    }
}
