package Java.AtoZ.Arrays;

public class Leaders {
    // Leader is an element that is greater than all of the elements on its right
    // side in the array.
    public static void findLeaders(int[] arr) {
        int length = arr.length;
        int leader = arr[length - 1];

        // The right most element is always a leader;
        System.out.println(leader);

        for (int i = length - 2; i >= 0; i--) {
            if (arr[i] > leader) {
                System.out.print(arr[i] + ",");
                leader = arr[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 7, 12, 0 };
        findLeaders(arr);
    }
}
