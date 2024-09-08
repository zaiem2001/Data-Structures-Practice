package Java.AtoZ.Recursion;

public class Pow {
    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        long absN = n < 0 ? -1 * (long) n : n;
        double answer = 1;

        while (absN > 0) {
            if (absN % 2 == 0) {
                x = x * x;
                absN = absN / 2;
            } else {
                answer = answer * x;
                absN = absN - 1;
            }
        }

        if (n < 0) {
            answer = (double) 1 / (double) answer;
        }

        return answer;
    }

    public static double powHelper(double x, long n, double answer) {
        if (n == 0)
            return answer;

        if (n % 2 == 0) {
            // x = x * x;
            // n = n / 2;

            return powHelper(x * x, n / 2, answer);
        } else {
            // answer = x * answer;
            // n--;

            return powHelper(x, n - 1, answer * x);
        }
        // return powHelper(x, n, answer);

    }

    public static double myPow_recursive(double x, int n) {
        if (n == 0)
            return 1;

        long absN = n < 0 ? -1 * n : n;
        double answer = 1;

        answer = powHelper(x, absN, answer);

        if (n < 0) {
            answer = (double) 1 / (double) answer;
        }

        return answer;
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2147483648;

        System.out.println(myPow(x, n));
        // System.out.println(myPow_recursive(x, n));
    }
}
