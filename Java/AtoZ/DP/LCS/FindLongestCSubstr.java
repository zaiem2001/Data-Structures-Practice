package Java.AtoZ.DP.LCS;

public class FindLongestCSubstr {
    static int longest(String s1, String s2, int n, int m, int count) {
        if (n < 0 || m < 0)
            return count;

        char c1 = s1.charAt(n);
        char c2 = s2.charAt(m);

        if (c1 == c2) {
            count = longest(s1, s2, n - 1, m - 1, count + 1);
        }

        int resetCounter1 = longest(s1, s2, n - 1, m, 0);
        int resetCounter2 = longest(s1, s2, n, m - 1, 0);

        return Math.max(resetCounter1, Math.max(count, resetCounter2));
    }

    public static void main(String[] args) {
        String str1 = "ABCDGH";
        String str2 = "ACDGHR";
        int n = str1.length();
        int m = str2.length();
        int count = 0;

        System.out.println(longest(str1, str2, n - 1, m - 1, count));
    }
}
