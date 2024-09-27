package Java.AtoZ.DP.LCS;

public class EditDis {
    static int minConversions(String word1, String word2, int n, int m) {
        if (n < 0)
            return m + 1;
        if (m < 0)
            return n + 1;

        char c1 = word1.charAt(n);
        char c2 = word2.charAt(m);

        if (c1 == c2) {
            return minConversions(word1, word2, n - 1, m - 1);
        }

        int insert = 1 + minConversions(word1, word2, n, m - 1);
        int delete = 1 + minConversions(word1, word2, n - 1, m);
        int replace = 1 + minConversions(word1, word2, n - 1, m - 1);

        return Math.min(replace, Math.min(insert, delete));
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";

        int n = word1.length();
        int m = word2.length();

        System.out.println(minConversions(word1, word2, n - 1, m - 1));
    }
}
