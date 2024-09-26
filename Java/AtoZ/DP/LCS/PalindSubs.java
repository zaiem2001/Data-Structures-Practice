package Java.AtoZ.DP.LCS;

import java.util.ArrayList;
import java.util.List;

public class PalindSubs {
    static int subsequence(String s, List<String> ds, int n, StringBuilder sb) {
        if (n < 0) {
            String reversed = new StringBuilder(sb).reverse().toString();
            ds.add(reversed);
            if (reversed.equals(sb.toString()))
                return sb.length();
            return 0;
        }

        sb.append(s.charAt(n));
        int pick = subsequence(s, ds, n - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        int notPick = subsequence(s, ds, n - 1, sb);

        return Math.max(pick, notPick);
    }

    public static void main(String[] args) {
        String s = "cabxxbc";
        List<String> ds = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        System.out.println(subsequence(s, ds, s.length() - 1, sb));
        System.out.println(ds);
    }
}
