package Java.Problems;

import java.util.ArrayList;
import java.util.List;

public class MaxArea {
    public static int getMaxArea(List<Integer> heights) {
        int maxHeight = 0;

        if (heights.size() == 0 || heights.size() == 1)
            return maxHeight;
        if (heights.size() == 2)
            return Math.min(heights.get(0), heights.get(1));

        for (int i = 0; i < heights.size(); i++) {
            for (int j = i + 1; j < heights.size(); j++) {
                if (j != i + 1 && heights.get(j) < heights.get(j - 1))
                    continue;

                int minEl = Math.min(heights.get(i), heights.get(j));
                int area = minEl * (j - i);

                if (area > maxHeight)
                    maxHeight = area;
            }
        }

        return maxHeight;
    }

    // using two pointers.
    public static int getMaxArea_optimal(List<Integer> heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.size() - 1;

        while (left < right) {
            int leftEl = heights.get(left);
            int rightEl = heights.get(right);
            int minValue = Math.min(leftEl, rightEl);

            int area = minValue * (right - left);

            if (area > maxArea)
                maxArea = area;

            if (leftEl > rightEl)
                right--;
            else
                left++;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        List<Integer> heights = new ArrayList<>();
        heights.add(4);
        heights.add(8);
        heights.add(1);
        heights.add(2);
        heights.add(3);
        heights.add(9);

        System.out.println(MaxArea.getMaxArea(heights));
        System.out.println(MaxArea.getMaxArea_optimal(heights));
    }
}
