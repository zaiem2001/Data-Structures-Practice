package Java.AtoZ.Stringss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountAnagrams {
    static int countAnagrams(String s, String p) {
        int count = 0;
        List<Integer> output = new ArrayList<>();

        if (p.length() > s.length())
            return count;

        HashMap<Character, Integer> pMapping = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pMapping.put(p.charAt(i), pMapping.getOrDefault(p.charAt(i), 0) + 1);
        }

        int windowSize = p.length();
        int distinctElem = pMapping.size();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            Character currChar = s.charAt(right);

            if (pMapping.containsKey(currChar)) {
                pMapping.put(currChar, pMapping.getOrDefault(currChar, 0) - 1);
                if (pMapping.get(currChar) == 0) {
                    distinctElem--;
                }
            }

            if (right >= windowSize - 1) {
                if (distinctElem == 0) {
                    count++;
                    output.add(left);
                }

                if (pMapping.containsKey(s.charAt(left))) {
                    pMapping.put(s.charAt(left), pMapping.get(s.charAt(left)) + 1);
                    if (pMapping.get(s.charAt(left)) == 1) {
                        distinctElem++;
                    }
                }
                left++;
            }
        }

        System.out.println(output);
        return count;
    }

    public static void main(String[] args) {
        String s = "baa";
        String p = "aa";

        System.out.println(countAnagrams(s, p));
    }
}
