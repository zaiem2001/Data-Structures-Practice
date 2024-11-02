package Java.AtoZ.DP.DP_2D;

import java.util.Arrays;

public class NumMatrix {
    static int[][] prefix;

    static void initialize(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        prefix = new int[n][m];
        prefix[0][0] = matrix[0][0];

        for (int i = 1; i < n; i++) {
            prefix[i][0] = prefix[i - 1][0] + matrix[i][0];
        }

        for (int j = 1; j < m; j++) {
            prefix[0][j] = prefix[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + matrix[i][j];
            }
        }
    }

    public static int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2][col2] - prefix[row1 - 1][col2] - prefix[row2][col1 - 1] + prefix[row1 - 1][col1 - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
                { 1, 0, 3, 0, 5 } };

        initialize(matrix);
        System.out.println(Arrays.deepToString(prefix));

        System.out.println(sumRegion(2, 1, 4, 3));
    }
}
