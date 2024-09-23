package Java.AtoZ.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    static int[][] insert(int[][] intervals, int[] newInterval) {
        boolean inserted = false;
        // List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = intervals[i];

            if (newInterval[0] < currInterval[1] && !inserted) {
                intervals[i][1] = newInterval[1];
                inserted = true;
            } else if (i != 0 && currInterval[0] < intervals[i - 1][1]) {
                intervals[i - 1][1] = Math.max(currInterval[1], intervals[i - 1][1]);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(currInterval[0]);
                temp.add(currInterval[1]);
                // result.add(temp);
            }
        }

        return intervals;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };

        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }
}
