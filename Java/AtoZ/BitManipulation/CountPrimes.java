package Java.AtoZ.BitManipulation;

public class CountPrimes {
    static int countPrimes(int n) {
        int count = 0;

        if (n == 0 || n == 1)
            return count;

        int[] primes = new int[n];
        for (int i = 2; i < n; i++) {
            primes[i] = 1;
        }

        for (int i = 2; i * i < n; i++) {
            if (primes[i] == 1) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = 0;
                }
            }
        }

        for (int x : primes) {
            if (x == 1)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(3));
    }
}
