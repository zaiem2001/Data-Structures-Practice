package Java.AtoZ.Arrays;

public class MaxSbArrSum {

    // Never carry negative ahead! (in your life too!!!)
    public static void kadanesAlgo(int[] arr) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0, ansStart = -1, ansEnd = -1;

        for (int i = 0; i < arr.length; i++) {
            if (sum == 0)
                start = i;

            sum += arr[i];

            if (sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0)
                sum = 0;
        }

        System.out.println(maxSum);
        System.out.println(ansStart + "-" + ansEnd);
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, 1, -2, 1, 5, };
        kadanesAlgo(arr);

    }
}
