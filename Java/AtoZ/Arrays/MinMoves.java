package Java.AtoZ.Arrays;

public class MinMoves {
    public static int findMinMoves(int[] A) {
        int moves = 0;
        int prev = 0;

        for (int element : A) {
            if (element > prev) {
                // we need to lift the interval.
                int requiredMoves = element - prev;
                moves += requiredMoves;
            }
            prev = element;
        }

        return moves;
    }

    public static void main(String[] args) {
        int[] A = { 5, 4, 2, 4, 1 };

        System.out.println(findMinMoves(A));
    }
}
