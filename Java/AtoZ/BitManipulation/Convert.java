package Java.AtoZ.BitManipulation;

public class Convert {
    static String decimalToBinary(int x) {
        if (x == 0)
            return "0";

        StringBuilder binary = new StringBuilder();

        while (x > 0) {
            if (x == 1) {
                binary.append(1);
                break;
            }
            int remainder = x % 2;
            binary.append(remainder);
            x /= 2;
        }
        binary.reverse();

        return binary.toString();
    }

    static int binaryToDecimal(String binary) {
        int decimal = 0;
        int pow = 1;

        if (binary.length() == 1)
            return Integer.parseInt(binary);

        for (int i = binary.length() - 1; i >= 0; i--) {
            int number = Integer.parseInt(String.valueOf(binary.charAt(i)));

            if (number == 1) {
                decimal += pow;
            }

            pow *= 2;
        }

        return decimal;
    }

    static void swap(int a, int b) {
        System.out.println(a + " " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After swapping...");
        System.out.println(a + " " + b);
    }

    static int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((xor & (1 << i)) != 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int x = 11;
        System.out.println(decimalToBinary(x));
        System.out.println(binaryToDecimal(decimalToBinary(x)));
        swap(11, 7);
        System.out.println(minBitFlips(10, 7));
    }
}
