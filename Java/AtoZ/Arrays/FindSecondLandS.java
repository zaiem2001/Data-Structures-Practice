package Java.AtoZ.Arrays;

public class FindSecondLandS {
    public static void findSecondLandS(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int i : arr) {
            System.out.println(i);
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }

        for (int j : arr) {
            if (j > secondMax && j != max)
                secondMax = j;
            if (j < secondMin && j != min)
                secondMin = j;
        }

        System.out.println("Second Max " + secondMax + " Second Min " + secondMin);
        // System.out.println(" Max " + max + " Min " + min);
    }

    public static void findSecLargest(int[] arr) {
        if (arr.length < 2)
            return;

        int max = Integer.MIN_VALUE;
        int secondMax = max;

        for (int n : arr) {
            if (n > max) {
                secondMax = max;
                max = n;
            } else if (n > secondMax && n != max) {
                secondMax = n;
            }
        }

        System.out.println("Second Max " + secondMax);

    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 2, 1, 6, 10, 12, 13 };

        findSecondLandS(arr);
        findSecLargest(arr);
    }
}
