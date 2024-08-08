package Java.AtoZ.Arrays;

public class MaxConsOnes {
    public static void findMaxCon1s(int[] arr) {
        int count = 0;
        int max1s = 0;

        if (arr.length == 1)
            System.out.println(arr[0] == 1 ? 1 : 0);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            max1s = Math.max(max1s, count);
        }
        System.out.println(max1s);
    }

    public static void main(String[] args) {
        int[] arr = { 1 };

        findMaxCon1s(arr);
    }
}
