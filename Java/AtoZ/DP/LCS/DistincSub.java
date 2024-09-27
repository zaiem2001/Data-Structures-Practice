package Java.AtoZ.DP.LCS;

public class DistincSub {
    static int count(String s, String t, int n, int m, int[][] dp) {
        if (m < 0)
            return 1;
        if (n < 0)
            return 0;

        if (dp[n][m] != 0)
            return dp[n][m];

        char c1 = s.charAt(n);
        char c2 = t.charAt(m);

        if (c1 == c2) {
            return dp[n][m] = count(s, t, n - 1, m - 1, dp) + count(s, t, n - 1, m, dp);
        }

        return dp[n][m] = count(s, t, n - 1, m, dp);
    }

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";

        int n = s.length();
        int m = t.length();
        // int[][] dp = new int[n + 1][m + 1];
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        prev[0] = 1;
        // for (int i = 0; i <= n; i++)
        // dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            curr[0] = 1;

            for (int j = 1; j <= m; j++) {
                char c1 = s.charAt(i - 1);
                char c2 = t.charAt(j - 1);

                if (c1 == c2) {
                    curr[j] = prev[j - 1] + prev[j];
                } else
                    curr[j] = prev[j];
            }
            prev = curr.clone();
        }

        System.out.println(prev[m]);
        // System.out.println(dp[n][m]);
        // System.out.println(count(s, t, n - 1, m - 1, dp));
    }

}
