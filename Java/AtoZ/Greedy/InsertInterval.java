package Java.AtoZ.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        // for non merging intervals
        int n = intervals.length;
        int i = 0;

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        // int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 2, 5 };

        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }
}
