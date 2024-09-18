package Java.AtoZ.StackNQueue;

import java.util.Stack;

public class MaxRectangle {
    static int[][] getPrefixMat(char[][] matrix) {
        int[][] pMat = new int[matrix.length][matrix[0].length];

        for (int j = 0; j < matrix[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                sum += matrix[i][j] - '0';
                if (matrix[i][j] == '0')
                    sum = 0;
                pMat[i][j] = sum;
            }
        }

        return pMat;
    }

    static int getMaxArea(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int elem = arr[i];
            while (!s.isEmpty() && arr[s.peek()] > elem) {
                int nse = i;
                int currHeight = arr[s.peek()];
                s.pop();
                int pse = s.isEmpty() ? -1 : s.peek();
                int area = currHeight * (nse - pse - 1);
                maxArea = Math.max(maxArea, area);
            }
            s.add(i);
        }

        while (!s.isEmpty()) {
            int nse = n;
            int currHeight = arr[s.peek()];
            s.pop();
            int pse = s.isEmpty() ? -1 : s.peek();
            int area = currHeight * (nse - pse - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    static int maximumRect(char[][] matrix) {
        int[][] prefixMat = getPrefixMat(matrix);
        int maxArea = 0;

        for (int[] row : prefixMat) {
            maxArea = Math.max(maxArea, getMaxArea(row));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '1', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(maximumRect(matrix));
    }
}
