package Java.AtoZ.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void combine(String digits, List<String> res, StringBuilder currString, int idx,
            Map<String, String> digitsMp) {
        if (currString.length() == digits.length()) {
            res.add(currString.toString());
            return;
        }

        String mapping = digitsMp.get(Character.toString(digits.charAt(idx)));

        for (char c : mapping.toCharArray()) {
            combine(digits, res, currString.append(c), idx + 1, digitsMp);
            currString.deleteCharAt(currString.length() - 1);
        }

        return;
    }

    static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder currString = new StringBuilder();
        Map<String, String> digitsMp = new HashMap<>();
        digitsMp.put("2", "abc");
        digitsMp.put("3", "def");
        digitsMp.put("4", "ghi");
        digitsMp.put("5", "jkl");
        digitsMp.put("6", "mno");
        digitsMp.put("7", "pqrs");
        digitsMp.put("8", "tuv");
        digitsMp.put("9", "wxyz");

        if (digits.length() > 0) {
            combine(digits, res, currString, 0, digitsMp);
        }

        return res;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}