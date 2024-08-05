package Java.Patterns;

import java.util.Scanner;

public class Patterns {
    /*
     * *****
     * *****
     * *****
     * *****
     */
    public static void pattern1(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /*
     * *
     * **
     * ***
     * ****
     */
    public static void pattern2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }

    public static void pattern3(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern4(int n) {
        for (int i = 1; i <= 2 * n - 1; i++) {
            int stars = i > n ? 2 * n - i : i;

            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void pyramid(int n) {
        for (int i = 0; i < n; i++) {
            // Spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }

            // Spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    public static void pyramid_inverse(int n) {
        for (int i = 0; i < n; i++) {
            // Spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < ((n - i) * 2) - 1; j++) {
                System.out.print("*");
            }

            // Spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    public static void pattern5(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String output = (j + i) % 2 == 0 ? "1" : "0";
                System.out.print(output);
            }
            System.out.println();
        }
    }

    public static void pattern6(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(j + 1);
            }

            for (int j = 0; j < (2 * (n - i)) - 2; j++) {
                System.out.print(" ");
            }

            for (int j = i + 1; j > 0; j--) {
                System.out.print(j);
            }

            System.out.println();
        }
    }

    public static void pattern7(int n) {
        for (int i = 0; i < n; i++) {
            char chr = 'A';
            for (int j = 0; j <= i; j++) {
                System.out.print(chr);
                chr++;
            }
            System.out.println();
        }

    }

    public static void pyramid_alpha(int n) {
        for (int i = 0; i < n; i++) {
            // Spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            char chr = 'A';
            int colLoop = 2 * i + 1;

            for (int j = 0; j < colLoop; j++) {
                System.out.print(chr);
                if (j >= colLoop / 2) {
                    chr--;
                } else
                    chr++;
            }

            // Spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern8(int n) {

        for (int i = 0; i < n; i++) {
            char start = 'A';
            start += n - i - 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(start);
                start++;
            }
            System.out.println();
        }
    }

    public static void pattern9(int n) {
        int spaces = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }

            System.out.println();
            spaces += 2;
        }
    }

    public static void pattern9_reverse(int n) {
        int spaces = 2 * (n - 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
            spaces -= 2;
        }
    }

    public static void pattern10(int n) {
        int spaces = 2 * (n - 1);

        for (int i = 1; i < 2 * n - 1; i++) {
            int stars = i;

            if (i > n)
                stars = 2 * n - i;

            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }

            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }

            System.out.println();
            if (i < n)
                spaces -= 2;
            else
                spaces += 2;
        }
    }

    public static void square(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean printStar = i == 0 || j == 0 || j == n - 1 || i == n - 1;

                if (printStar)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern11(int n) {
        int loops = 2 * n - 1;

        for (int i = 0; i < loops; i++) {
            for (int j = 0; j < loops; j++) {
                int top = i;
                int left = j;
                int right = (2 * n - 2) - j;
                int bottom = (2 * n - 2) - i;

                int number = n - Math.min(Math.min(top, bottom), Math.min(right, left));
                System.out.print(number);
            }

            System.out.println();
        }

    }

    public static void main(String[] args) {
        // pyramid(4);
        // pyramid_inverse(4);
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter number of rows: ");
        // int n = sc.nextInt();
        // sc.close();

        pattern1(4);
        System.out.println("--------------");
        pattern2(4);
        System.out.println("--------------");
        pattern3(4);
        System.out.println("--------------");
        pattern4(4);
        System.out.println("--------------");
        pattern5(4);
        System.out.println("--------------");
        pattern6(4);
        System.out.println("--------------");
        pattern7(4);
        System.out.println("--------------");
        pattern8(4);
        System.out.println("--------------");
        pattern9(4);
        System.out.println("--------------");
        pattern10(4);
        System.out.println("--------------");
        pattern11(4);
        System.out.println("--------------");

    }
}
