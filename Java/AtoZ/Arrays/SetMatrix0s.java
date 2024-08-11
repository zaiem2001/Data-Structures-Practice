package Java.AtoZ.Arrays;

import java.util.Arrays;

public class SetMatrix0s {
    public static void setMatrixto0s(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int rows[] = new int[m]; // o(m)
        int cols[] = new int[n]; // o(n)

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == 1 || cols[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        // System.out.println(Arrays.toString(rows));
        // System.out.println(Arrays.toString(cols));
    }

    public static void main(String[] args) {
        int[][] arr = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        setMatrixto0s(arr);
    }
}
