package Java.AtoZ.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Pascals {
    public static void generatePascalsRow(int n) {
        int row[] = new int[n];
        row[0] = 1;
        int answer = 1;

        for (int col = 1; col < n; col++) {
            answer *= n - col;
            answer /= col;
            row[col] = answer;
        }

        System.out.println(Arrays.toString(row));

    }

    public static void generate(int n) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        if (n <= 0)
            return;

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        if (n == 1)
            return;

        for (int i = 1; i < n; i++) {
            triangle.add(new ArrayList<>());

            for (int j = 0; j < i + 1; j++) {
                triangle.get(i).add(0);

                if (j == 0 || i == j)
                    triangle.get(i).set(j, 1);
                else {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
        }
        System.out.println(triangle);
    }

    public static void main(String[] args) {
        generate(6);
        generatePascalsRow(5);
    }
}
