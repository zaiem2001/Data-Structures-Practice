package Java.AtoZ.Stringss;

import java.util.HashMap;

public class MinWindowSub {
    static String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            if (tMap.containsKey(currChar)) {
                int charCount = tMap.get(currChar);
                tMap.put(currChar, charCount - 1);

                if (tMap.get(currChar) >= 0) {
                    count++;
                }
            }

            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    startIndex = left;
                    minLen = right - left + 1;
                }

                char leftChar = s.charAt(left);

                if (tMap.containsKey(leftChar)) {
                    int leftCount = tMap.get(leftChar);
                    tMap.put(leftChar, leftCount + 1);
                    if (tMap.get(leftChar) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}
