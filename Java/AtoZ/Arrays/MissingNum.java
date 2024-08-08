package Java.AtoZ.Arrays;

public class MissingNum {
    public static void findMissingNum(int[] nums) {
        int xor1 = 0;
        int xor2 = 0;
        int length = nums.length - 1;

        for (int i = 0; i < length; i++) {
            System.out.println(xor1 + "-" + xor2 + "-" + i);
            xor2 = xor2 ^ nums[i];
            xor1 = xor1 ^ (i + 1);
        }

        xor1 = xor1 ^ length;

        System.out.println(xor2 ^ xor1);
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1 };

        findMissingNum(arr);

    }
}
