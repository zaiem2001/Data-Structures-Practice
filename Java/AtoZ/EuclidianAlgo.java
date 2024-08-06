package Java.AtoZ;

public class EuclidianAlgo {
    // Time complexity for this is O(min(a,b))
    public static void calculateGCD(int a, int b) {
        int gcd = 1;

        for (int i = Math.min(a, b); i > 0; i--) {

            if (a % i == 0 && b % i == 0) {
                gcd = i;
                break;
            }
        }
        System.out.println(gcd);
    }

    /**
     * Another method to find the GCD is euclidian algorithm
     * it states that the GCD(a,b) = GCD(a - b, b); where a > b;
     * here we will do gcd(a,b) = gcd(a % b, b); where a > b;
     * time complexity for this is O(logi min(a,b))
     **/

    public static void euclidianGCD(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b)
                a = a % b;
            else
                b = b % a;
        }

        int output = a == 0 ? b : a;
        System.out.println(output);
    }

    public static void main(String[] args) {
        calculateGCD(715, 125);
        euclidianGCD(715, 1215);
    }

}
