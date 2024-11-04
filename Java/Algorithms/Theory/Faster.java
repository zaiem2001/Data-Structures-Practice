package Java.Algorithms.Theory;

class Faster {
    static int getCrossoverPoint(int n) {
        int low = 0;
        int high = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            double poly = 100 * mid * mid;
            double expo = Math.pow(2, mid);

            if (poly > expo) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    public static void main(String[] args) {
        System.out.println(getCrossoverPoint(20));
    }
}