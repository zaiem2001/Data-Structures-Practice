package Java.AtoZ.DP;

public class Fib {
    static int fib(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // if (n < 2)
        // return n;
        // System.out.println(Arrays.toString(dp));

        return dp[n];
    }

    static int climb(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(fib(n));
        System.out.println(climb(4));
    }
}
