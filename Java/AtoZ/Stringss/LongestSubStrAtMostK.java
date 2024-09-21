package Java.AtoZ.Stringss;

import java.util.HashMap;

public class LongestSubStrAtMostK {
    static int findLongest(String s, int k) {
        int longest = 0;
        HashMap<Character, Integer> mpp = new HashMap<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            mpp.put(s.charAt(right), mpp.getOrDefault(s.charAt(right), 0) + 1);

            while (mpp.size() > k) {
                int leftChar = mpp.get(s.charAt(left));

                if (leftChar == 1)
                    mpp.remove(s.charAt(left));
                else
                    mpp.put(s.charAt(left), leftChar - 1);

                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println(findLongest(s, k));
    }
}
