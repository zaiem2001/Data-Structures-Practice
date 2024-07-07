package Java.Problems;

public class RemoveDuplicates {

    // Using two pointers appraoch
    public static int removeDuplicates(int[] numbers) {
        int left = 0;

        for (int right = 1; right < numbers.length; right++) {
            System.out.println(numbers);
            if (numbers[right] != numbers[left]) {
                numbers[left + 1] = numbers[right];
                left++;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

        System.out.println(removeDuplicates(nums));

    }

}
