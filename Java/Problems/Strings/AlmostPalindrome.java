package Java.Problems.Strings;

// Check if the string is almost palindrome.
// A string is almost palindrome if, by removing one character it can become palindrome.
// NOTE: an empty string, string.length =1, and string.length =2, all these should return true.
public class AlmostPalindrome {
    private static boolean validSubPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(right) != str.charAt(left))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean checkAlmostPalindrome(String str) {
        if (str.length() == 0 || str.length() == 1 || str.length() == 2)
            return true;
        String alphanumericStr = str.replaceAll("[^\\w]", "").toLowerCase();
        int left = 0, right = alphanumericStr.length() - 1;

        while (left < right) {
            if (alphanumericStr.charAt(left) != alphanumericStr.charAt(right)) {
                return validSubPalindrome(alphanumericStr, left + 1, right)
                        || validSubPalindrome(alphanumericStr, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(checkAlmostPalindrome("ab c c d b a"));
        System.out.println(checkAlmostPalindrome("abcdefdba"));
        System.out.println(checkAlmostPalindrome("!@dadda"));
    }
}
