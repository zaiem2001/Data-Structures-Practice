package Java.AtoZ.BinarySearch;

public class SqRoot {
    public static void floorSqrt(int n) {
        int low = 1, high = n;
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if ((mid * mid) <= n) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }

        // System.out.println(ans);
        System.out.println(high);
    }

    public static void NthRoot(int n, int m) {
        long low = 0, high = m;
        long ans = -1;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (Math.pow((double) mid, (double) n) == (double) m) {
                ans = mid;
                break;
            } else if (Math.pow((double) mid, (double) n) > (double) m) {
                high = mid - 1;
            } else
                low = mid + 1;
        }

        System.out.println(ans);

    }

    public static void main(String[] args) {
        // floorSqrt(5);
        NthRoot(3, 9);

    }
}
