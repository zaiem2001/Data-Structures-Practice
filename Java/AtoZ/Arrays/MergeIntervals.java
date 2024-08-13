package Java.AtoZ.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < intervals.length; i++) {
            if (merged.size() == 0 || intervals[i][0] > merged.getLast()[1]) {
                merged.add(intervals[i]);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(intervals[i][1], merged.getLast()[1]);
            }
        }

        int[][] result = merged.toArray(new int[merged.size()][2]);
        System.out.println(Arrays.deepToString(result));

    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 15, 18 }, { 2, 6 }, { 8, 10 } };
        // int[][] arr = { { 1, 4 }, { 4, 5 } };

        merge(arr);

    }
}
