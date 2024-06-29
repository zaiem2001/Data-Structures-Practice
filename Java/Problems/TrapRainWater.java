package Java.Problems;

import java.util.ArrayList;
import java.util.List;

public class TrapRainWater {
    public static int countRainArea(List<Integer> waterArea) {
        int totalWater = 0;

        for (int i = 0; i < waterArea.size(); i++) {
            int leftP = i, rightP = i;
            int maxLeft = 0, maxRight = 0;
            int totalArea = 0;

            while (leftP >= 0) {
                if (waterArea.get(leftP) > maxLeft)
                    maxLeft = waterArea.get(leftP);
                leftP--;
            }

            while (rightP < waterArea.size()) {
                if (waterArea.get(rightP) > maxRight)
                    maxRight = waterArea.get(rightP);
                rightP++;
            }

            totalArea = Math.min(maxLeft, maxRight) - waterArea.get(i);
            if (totalArea >= 0)
                totalWater += totalArea;

        }

        return totalWater;

    }

    // Two pointers
    public static int countRainArea_optimal(List<Integer> waterArea) {
        int maxArea = 0;
        int leftP = 0, rightP = waterArea.size() - 1;
        int leftMax = 0, rightMax = 0;

        while (leftP < rightP) {
            int leftVal = waterArea.get((leftP));
            int rightVal = waterArea.get((rightP));

            if (leftVal < rightVal) {
                if (leftMax < leftVal) {
                    leftMax = leftVal;
                } else {
                    maxArea += leftMax - leftVal;
                }
                leftP++;
            } else {
                if (rightMax < rightVal) {
                    rightMax = rightVal;
                } else {
                    maxArea += rightMax - rightVal;
                }
                rightP--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        List<Integer> waterArea = new ArrayList<>();
        waterArea.add(0);
        waterArea.add(1);
        waterArea.add(0);
        waterArea.add(2);
        waterArea.add(1);
        waterArea.add(0);
        waterArea.add(3);
        waterArea.add(1);
        waterArea.add(0);
        waterArea.add(1);
        waterArea.add(2);

        System.out.println(TrapRainWater.countRainArea(waterArea));
        System.out.println(TrapRainWater.countRainArea_optimal(waterArea));

    }
}
