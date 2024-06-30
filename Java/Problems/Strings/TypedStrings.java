package Java.Problems.Strings;

import java.util.ArrayList;
import java.util.List;

// Given two strings, verify that two strings are equal when,
// 1. whne you see a # in any string that means backspace.
// eg:- ab#c == ab; c got deleted,
// eg:- abc## = a; c and b got deleted
public class TypedStrings {
    public static boolean checkStrings_optimal(String s1, String s2) {
        int p1 = s1.length() - 1;
        int p2 = s2.length() - 1;

        while (p1 >= 0 || p2 >= 0) {
            char s1_char = s1.charAt(p1);
            char s2_char = s2.charAt(p2);

            if (s1_char == '#') {
                int backspace = 2;
                while (backspace > 0) {
                    p1--;
                    backspace--;
                    if (s1.charAt(p1) == '#') {
                        backspace += 2;
                    }
                }

            }
            if (s2_char == '#') {
                int backspace = 2;
                while (backspace > 0) {
                    p2--;
                    backspace--;
                    if (s2.charAt(p2) == '#') {
                        backspace += 2;
                    }
                }
            }

            return s1.charAt(p1) == s2.charAt(p2);
        }

        return true;
    }

    public static boolean checkStrings(String s1, String s2) {
        String s1_enhanced = filterOutHashtags(s1);
        String s2_enhanced = filterOutHashtags(s2);

        return s1_enhanced.equals(s2_enhanced);
    }

    private static String filterOutHashtags(String s2) {
        List<String> myList = new ArrayList<>();

        for (String chr : s2.split("")) {
            if (chr.equals("#")) {
                if (myList.size() > 0)
                    myList.removeLast();
            } else
                myList.add(chr);
        }

        return String.join("", myList);
    }

    public static void main(String[] args) {
        String s1 = "ab#c";
        String s2 = "a##c";

        System.out.println(TypedStrings.checkStrings(s1, s2));
        System.out.println(TypedStrings.checkStrings_optimal(s1, s2));
    }
}
