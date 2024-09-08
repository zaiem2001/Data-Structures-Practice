package Java.AtoZ.Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParan {
    public static void helper(int n, int open, int close, List<String> result, StringBuilder ds) {
        if (open == n && close == n) {
            // we have a valid paranthesis.
            result.add(ds.toString());
            return;
        }

        if (open < n) {
            ds.append("(");
            // ds.add("(");
            helper(n, open + 1, close, result, ds);
            // ds.remove(ds.size() - 1);
            ds.deleteCharAt(ds.length() - 1);
        }

        if (close < open) {
            // ds.add(")");
            ds.append(")");
            helper(n, open, close + 1, result, ds);
            // ds.remove(ds.size() - 1);
            ds.deleteCharAt(ds.length() - 1);
        }
    }

    static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder ds = new StringBuilder();

        helper(n, 0, 0, result, ds);

        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
