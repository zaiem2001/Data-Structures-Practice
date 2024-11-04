package Java.AtoZ.Stringss;

public class Operations {
    static int findOperations(String s) {
        int n = s.length();
        if (n < 2)
            return 0;

        char initialChar = s.charAt(0);
        char initialEnd = s.charAt(n - 1);

        int left = 0;
        int right = n - 1;
        int operations = 0;

        while (left < right) {
            while (left < right && s.charAt(left) != initialChar) {
                operations++;
                left++;
            }

            while (left < right && s.charAt(right) != initialEnd) {
                right--;
                operations++;
            }

            left++;
            right--;
            operations++;
        }

        // if (s.charAt(left) != initialChar && s.charAt(right) != initialEnd)
        // return 0;

        return operations;
    }

    public static void main(String[] args) {
        // String s = "babdcaac"; // 5
        // String s = "abbc"; // 0
        String s = "hchc"; // 2

        System.out.println(findOperations(s));
    }
}