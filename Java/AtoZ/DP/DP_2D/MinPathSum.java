package Java.AtoZ.DP.DP_2D;

public class MinPathSum {

    static int solve(int row, int col, int[][] arr) {
        if (row == 0 && col == 0) {
            return arr[row][col];
        }

        if (row < 0 || col < 0)
            return (int) 1e9;

        int up = arr[row][col] + solve(row - 1, col, arr);
        // if (up != Integer.MAX_VALUE) {
        // up += arr[row][col];
        // }

        int left = arr[row][col] + solve(row, col - 1, arr);
        // if (left != Integer.MAX_VALUE) {
        // left += arr[row][col];
        // }

        // if (up != Integer.MAX_VALUE && left != Integer.MAX_VALUE) {
        // up += arr[row][col];
        // left += arr[row][col];
        // }

        return Math.min(up, left);
    }

    static int findMinPathSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        return solve(m - 1, n - 1, arr);
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

        System.out.println(findMinPathSum(arr));
    }
}
