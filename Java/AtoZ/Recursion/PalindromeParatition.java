package Java.AtoZ.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromeParatition {
    public static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void helper(int idx, String s, List<String> ds, List<List<String>> res) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                ds.add(s.substring(idx, i + 1));
                helper(i + 1, s, ds, res);
                ds.remove(ds.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        if (s.length() == 0)
            return res;

        helper(0, s, new ArrayList<>(), res);

        return res;
    }

    public static void main(String[] args) {
        String s = "abcbsa";
        System.out.println(partition(s));
    }
}
