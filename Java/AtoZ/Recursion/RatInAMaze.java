package Java.AtoZ.Recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    public static void solve(int i, int j, int n, StringBuilder path, int[][] maze, List<String> res, int[][] visited) {
        if (i == n - 1 && j == n - 1) {
            // we found the path
            res.add(path.toString());
            return;
        }

        // Down
        if (i + 1 < n && maze[i + 1][j] == 1 && visited[i + 1][j] == 0) {
            visited[i][j] = 1;
            solve(i + 1, j, n, path.append("D"), maze, res, visited);
            visited[i][j] = 0;
            path.deleteCharAt(path.length() - 1);
        }

        // Left
        if (j - 1 >= 0 && maze[i][j - 1] == 1 && visited[i][j - 1] == 0) {
            visited[i][j] = 1;
            solve(i, j - 1, n, path.append("L"), maze, res, visited);
            visited[i][j] = 0;
            path.deleteCharAt(path.length() - 1);
        }

        // Right
        if (j + 1 < n && maze[i][j + 1] == 1 && visited[i][j + 1] == 0) {
            visited[i][j] = 1;
            solve(i, j + 1, n, path.append("R"), maze, res, visited);
            visited[i][j] = 0;
            path.deleteCharAt(path.length() - 1);
        }

        // Up
        if (i - 1 >= 0 && maze[i - 1][j] == 1 && visited[i - 1][j] == 0) {
            visited[i][j] = 1;
            solve(i - 1, j, n, path.append("U"), maze, res, visited);
            visited[i][j] = 0;
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static List<String> findPath(int[][] maze, int n) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        int[][] visited = new int[n][n];

        if (maze[0][0] != 1)
            return res;

        solve(0, 0, n, path, maze, res, visited);
        return res;
    }

    public static void main(String[] args) {
        int[][] maze = { { 1, 1, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 }
        };

        int n = maze.length;
        System.out.println(findPath(maze, n));
    }
}
