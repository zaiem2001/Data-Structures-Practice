package Java.AtoZ.Arrays;

import java.util.HashSet;

public class LongestConsec {
    public static void findLongConsec(int[] arr) {
        if (arr.length == 0)
            return;

        int count = 0;
        int longest = 1;
        HashSet<Integer> mySet = new HashSet<>();

        for (int x : arr) {
            mySet.add(x);
        }

        for (int x : mySet) {
            if (!mySet.contains(x - 1)) {
                count = 1;
                int temp = x;

                while (mySet.contains(temp + 1)) {
                    temp++;
                    count++;
                }
                longest = Math.max(count, longest);
            }
        }
        System.out.println(longest);
    }

    public static void main(String[] args) {
        // int[] arr = { 100, 4, 200, 1, 3, 2 };
        int[] arr = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        findLongConsec(arr);
    }
}
