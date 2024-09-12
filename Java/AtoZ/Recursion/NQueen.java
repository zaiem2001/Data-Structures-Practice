package Java.AtoZ.Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueen {
    static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void solve(int col, char[][] board, List<List<String>> result, int[] leftRow, int[] upperDiag,
            int[] lowerDiag) {

        if (board.length == col) {
            result.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiag[row + col] == 0 && upperDiag[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiag[row + col] = 1;
                upperDiag[board.length - 1 + col - row] = 1;
                solve(col + 1, board, result, leftRow, upperDiag, lowerDiag);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiag[row + col] = 0;
                upperDiag[board.length - 1 + col - row] = 0;
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        int[] leftRow = new int[n];
        int[] upperDiag = new int[2 * n - 1];
        int[] lowerDiag = new int[2 * n - 1];

        solve(0, board, result, leftRow, upperDiag, lowerDiag);

        return result;
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(solveNQueens(n));
    }
}
