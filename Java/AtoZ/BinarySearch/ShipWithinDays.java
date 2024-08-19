package Java.AtoZ.BinarySearch;

class ShipWithinDays {
    public static int[] findSumNMax(int[] arr) {
        double sum = 0;
        int max = Integer.MIN_VALUE;

        for (int x : arr) {
            sum += x;
            max = Math.max(x, max);
        }

        return new int[] { max, (int) sum };
    }

    public static int findDays(int[] weights, int mid) {
        int days = 1;
        int load = 0;

        for (int x : weights) {

            if (load + x > mid) {
                days++;
                load = x;
            } else {
                load += x;
            }
        }

        return days;
    }

    public static int shipDays(int[] weights, int days) {
        int low = findSumNMax(weights)[0];
        int high = findSumNMax(weights)[1];

        while (low <= high) {
            int mid = (low + high) / 2;
            int totalDays = findDays(weights, mid);

            if (totalDays <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // System.out.println(high);

        return low;
    }

    public static void main(String[] args) {
        // int[] arr = { 3, 2, 2, 4, 1, 4 };
        int[] arr = { 1, 2, 3, 1, 1 };
        // int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 4;
        System.out.println(shipDays(arr, days));

    }
}