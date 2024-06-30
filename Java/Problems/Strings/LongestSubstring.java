package Java.Problems.Strings;

import java.util.HashMap;
import java.util.Map;

// Determine the longest substring without repearing chars.
// eg: "abccabb" -> abc and cab are the longest substrings,
// without the repeating chars. Therefore, the ans is 3;
public class LongestSubstring {
    public static int findLongestSubstr_optimal(String str) {
        if (str.length() <= 1)
            return str.length();

        int maxSubstr = 0;
        int left = 0;
        Map<Character, Integer> hsMap = new HashMap<>();

        for (int right = 0; right < str.length(); right++) {
            Character currentChar = str.charAt(right);
            int prevSeenIdx = hsMap.getOrDefault(currentChar, -1);

            if (prevSeenIdx >= left) {
                left = prevSeenIdx + 1;
            }
            hsMap.put(currentChar, right);
            maxSubstr = Math.max(maxSubstr, (right - left) + 1);

        }

        return maxSubstr;

    }

    public static int findLongestSubstr(String str) {
        int maxSubstr = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            Map<Character, Integer> hsMap = new HashMap<>();
            int longestSubstr = 0;

            for (int j = i; j <= str.length() - 1; j++) {
                if (hsMap.get(str.charAt(j)) != null) {
                    break;
                } else {
                    hsMap.put(str.charAt(j), j);
                    longestSubstr++;
                }
            }

            if (longestSubstr > maxSubstr)
                maxSubstr = longestSubstr;
        }

        return maxSubstr;

    }

    public static void main(String[] args) {
        System.out.println(findLongestSubstr("zaiemmaiend"));
        System.out.println("Optimal ->" + findLongestSubstr_optimal("zaiemmaiend"));

    }
}
