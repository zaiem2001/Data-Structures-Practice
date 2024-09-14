package Java.AtoZ.BitManipulation;

public class TwoOddNums {
    // xor all the numbers
    // take the right most set bit and rest all 0s
    // the idea is that atleast one bit will be different between two numbers.
    // iterate again on the arr and do & with the rightmost set bit.
    // separate the & operations that results 1 and 0;
    static int[] check(int Arr[], int N) {
        if (Arr.length == 2) {
            if (Arr[0] > Arr[1]) {
                return new int[] { Arr[0], Arr[1] };
            }
            return new int[] { Arr[1], Arr[0] };
        }

        int xor = 0;
        for (int x : Arr) {
            xor ^= x;
        }
        int rightMostSetBit = (xor & xor - 1) ^ (xor);
        int b1 = 0, b2 = 0;

        for (int x : Arr) {
            if ((x & rightMostSetBit) != 0) {
                b1 ^= x;
            } else {
                b2 ^= x;
            }
        }
        System.out.println(b1 + "-" + b2);

        if (b1 > b2) {
            return new int[] { b1, b2 };
        }
        return new int[] { b2, b1 };
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 4, 5, 2, 3, 3, 1 };
        System.out.println(check(arr, arr.length));
    }
}
