package Java.AtoZ.Arrays;

public class LargestNumber {
    public static int findLargestNum(int[] A) {
        int maxNumber = Integer.MIN_VALUE;
        int n = A.length;

        // Check max for single digit
        for (int x : A) {
            maxNumber = Math.max(maxNumber, x);
        }

        // Check max for two digits;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int twoDigit = (A[i] * 10) + A[j];
                maxNumber = Math.max(maxNumber, twoDigit);
            }
        }

        // Check max for three digits.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int threeDigit = (A[i] * 100) + (A[j] * 10) + A[k];
                    maxNumber = Math.max(maxNumber, threeDigit);
                }
            }
        }

        return maxNumber;
    }

    public static void main(String[] args) {
        int[] A = { 0, 0, 5, 7 };

        System.out.println(findLargestNum(A));
    }
}
