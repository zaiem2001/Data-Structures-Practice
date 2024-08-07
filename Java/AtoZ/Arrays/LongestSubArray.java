package Java.AtoZ.Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArray {
    // This solution will work for both negative and positive integers.
    // And for negative integers, this is the most optimal solution.
    public static void findLongestSubArr(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }

            int preSum = sum - k;
            int hasPre = map.getOrDefault(preSum, -1);

            if (hasPre != -1) {
                maxLength = Math.max(maxLength, i - hasPre);
            }

            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        System.out.println(maxLength);
    }

    // More optimal than the above one.
    public static void findLongestSubArrPositiveInt(int[] arr, int k) {
        int maxLen = 0;
        int i = 0, j = 0;
        int sum = 0;

        while (i < arr.length) {
            sum += arr[i];

            if (sum == k)
                maxLen = Math.max(maxLen, i + 1);

            while (j <= i) {
                int preSum = sum - arr[j];
                if (preSum == k) {
                    maxLen = Math.max(maxLen, i - j + 1);
                    j++;
                }
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 3, 3, 5, 5 };
        int k = 16;
        findLongestSubArr(arr, k);
        findLongestSubArr(arr, k);
    }
}
