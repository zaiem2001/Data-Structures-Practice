package Java.AtoZ.Stringss;

public class RemoveParan {
    public static String removeOuterParentheses(String s) {
        if (s.length() <= 2)
            return "";

        int count = 0;
        String output = "";

        for (char c : s.toCharArray()) {
            if (count != 0 && c == '(') {
                count++;
                output += c;
            } else if (c == ')') {
                if (count != 1)
                    output += c;
                count--;
            } else {
                count++;
            }
        }

        return output;

    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("()()"));
    }
}
