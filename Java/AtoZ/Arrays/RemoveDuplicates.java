package Java.AtoZ.Arrays;

import java.util.Arrays;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {

        int i = 0;
        int j = 1;
        int length = nums.length;

        while (j < length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
                continue;
            }
            j++;
        }

        System.out.println(Arrays.toString(nums));
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 3, 4, 4, 4 };

        System.out.println(removeDuplicates(arr));
    }
}
