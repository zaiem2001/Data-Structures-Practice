package Java.AtoZ.Recursion;

public class WordSearch {
    public static boolean helper(char[][] board, int rows, int cols, int indx, String word, int row, int col,
            int[][] visited) {
        if (indx == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= rows || col >= cols || word.charAt(indx) != board[row][col]
                || visited[row][col] == 1) {
            return false;
        }

        visited[row][col] = 1;
        boolean res = (helper(board, rows, cols, indx + 1, word, row + 1, col, visited)
                || helper(board, rows, cols, indx + 1, word, row - 1, col, visited)
                || helper(board, rows, cols, indx + 1, word, row, col + 1, visited)
                || helper(board, rows, cols, indx + 1, word, row, col - 1, visited));

        visited[row][col] = 0;

        return res;
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        int idx = 0;
        int[][] visited = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(board, rows, cols, idx, word, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' },
        };

        String word = "ABFCS";

        System.out.println(exist(board, word));

    }
}
