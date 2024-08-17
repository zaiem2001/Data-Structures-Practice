package Java.AtoZ.BinarySearch;

public class Bounds {
    public static void searchInsert(int[] arr, int target) {
        int result = -1;
        int low = 0, high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == target) {
                result = mid;
                break;
            } else if (target > arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }

        System.out.println(result);
        System.out.println(low);
    }

    public static void main(String[] args) {

        int[] arr = { 1, 3, 4, 6 };

        searchInsert(arr, 5);

    }
}
