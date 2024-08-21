package Java.AtoZ.BinarySearch;

import Java.Utility.Helpers;

public class BookAllocation {
    public static int getTotalStudents(int[] arr, int m) {
        int students = 1, pages = 0;

        for (int x : arr) {
            if (x + pages <= m) {
                pages += x;
            } else {
                students++;
                pages = x;
            }
        }

        return students;
    }

    public static void findPages(int[] books, int m) {
        if (m > books.length) {
            System.out.println(-1);
            return;
        }

        int high = Helpers.findSum(books);
        if (m == 1) {
            System.out.println(high);
            return;
        }
        int low = Helpers.findMax(books);

        while (low <= high) {
            int mid = (low + high) / 2;

            int students = getTotalStudents(books, mid);

            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(low);
    }

    public static void main(String[] args) {
        int[] books = { 12, 34, 67, 90 };
        // int[] books = { 25, 46, 28, 49, 24 };
        // int[] books = { 48, 90 }; // This will also work for the Painters problem.
        findPages(books, 2);
    }
}
