package Java.AtoZ.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Spiral {
    public static void spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int totalElem = rows * cols;
        int left = 0, top = 0;
        int bottom = rows, right = cols;
        List<Integer> output = new ArrayList<>();

        while (output.size() != totalElem) {
            // left -> right
            for (int i = left; i < right && output.size() < totalElem; i++) {
                output.add(matrix[top][i]);
            }
            top++;

            // top -> bottom
            for (int i = top; i < bottom && output.size() < totalElem; i++) {
                output.add(matrix[i][right - 1]);
            }
            right--;

            // right -> left
            for (int i = right - 1; i >= left && output.size() < totalElem; i--) {
                output.add(matrix[bottom - 1][i]);
            }
            bottom--;

            // bottom -> top
            for (int i = bottom - 1; i >= top && output.size() < totalElem; i--) {
                output.add(matrix[i][left]);
            }
            left++;
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 } };
        spiralOrder(arr);
    }
}
