package Java.AtoZ.BitManipulation;

public class Divide {
    static int divide(int dividend, int divisor) {
        if (dividend == divisor)
            return 1;

        boolean sign = true; // positive
        if (dividend <= 0 && divisor > 0)
            sign = false;
        if (dividend >= 0 && divisor < 0)
            sign = false;

        int quotient = 0;
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        // divisor = Math.abs(divisor);

        System.out.println(n + " d" + d);

        while (n >= d) {
            int count = 0;
            while (n >= (d << (count + 1))) {
                count++;
            }
            quotient += 1 << count;
            n -= d << (count);
        }

        if (quotient == (1 << 31) && sign) {
            return Integer.MAX_VALUE;
        }
        if (quotient == (1 << 31) && !sign) {
            return Integer.MIN_VALUE;
        }

        return sign ? quotient : -1 * quotient;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 1));
    }
}
