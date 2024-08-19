package Java.AtoZ.BinarySearch;

public class KthPositive {
    public static int findKthPos(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else
                high = mid - 1;

        }

        return low + k;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int k = 11;
        System.out.println(findKthPos(arr, k));

    }
}
