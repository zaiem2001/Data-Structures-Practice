package Java.AtoZ.StackNQueue;

import java.util.Stack;

public class RemoveKDigits {
    static String removeKdigits(String num, int k) {
        int n = num.length();
        if (k == n)
            return "0";

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            char digit = num.charAt(i);

            while (!s.isEmpty() && k != 0 && s.peek() > digit) {
                s.pop();
                k--;
            }
            s.push(digit);
        }

        if (s.isEmpty())
            return "0";

        while (k != 0) {
            s.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();

        while (!s.isEmpty()) {
            ans.append(String.valueOf(s.peek()));
            s.pop();
        }

        if (ans.length() == 0)
            return "0";

        for (int i = ans.length() - 1; i >= 0 && ans.charAt(i) == '0'; i--) {
            ans.deleteCharAt(i);
        }

        if (ans.length() == 0)
            return "0";

        return ans.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("10", 2));
    }
}
