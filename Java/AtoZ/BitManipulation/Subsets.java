package Java.AtoZ.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    static List<List<Integer>> getSubsets(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();

        if (arr.length == 0)
            return res;

        int n = arr.length;
        int noOfSubsets = 1 << n;

        for (int i = 0; i < noOfSubsets; i++) {
            List<Integer> ds = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // Check if the ith bit is set if it is then add the ith value
                if ((i & (1 << j)) != 0) {
                    ds.add(arr[j]);
                }
            }
            res.add(ds);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(getSubsets(arr));
    }
}
