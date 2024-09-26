package Java.AtoZ.DP.LCS;

import java.util.Arrays;

public class FindLongestCommonSub {
    static int common(int n, int m, String s1, String s2) {
        if (n < 0 || m < 0)
            return 0;

        char charAtS1 = s1.charAt(n);
        char charAtS2 = s2.charAt(m);

        if (charAtS1 == charAtS2) {
            return 1 + common(n - 1, m - 1, s1, s2);
        }

        return Math.max(common(n - 1, m, s1, s2), common(n, m - 1, s1, s2));
    }

    public static void main(String[] args) {
        String s1 = "abdc";
        String s2 = "abc";
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for (int j = 0; j <= m; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char charAtS1 = s1.charAt(i - 1);
                char charAtS2 = s2.charAt(j - 1);

                if (charAtS1 == charAtS2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[n][m]);

        System.out.println(common(n - 1, m - 1, s1, s2));
    }
}
