package Java.AtoZ.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public static void threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        HashSet<List<Integer>> setArr = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int k = -(nums[i] + nums[j]);

                if (set.contains(k)) {
                    // int[] tempArr = { nums[i], nums[j], nums[k] };
                    List<Integer> tempArr = new ArrayList<>();
                    tempArr.add(nums[i]);
                    tempArr.add(nums[j]);
                    tempArr.add(k);
                    tempArr.sort(null);

                    setArr.add(tempArr);
                }
                set.add(nums[j]);
            }
        }

        for (List<Integer> s : setArr) {
            output.add(s);
        }

        System.out.println(output);
    }

    private static void optimalThreeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    Integer[] temp = { nums[i], nums[j], nums[k] };
                    output.add(Arrays.asList(temp));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }

        System.out.println(output);

    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 };
        threeSum(arr);
        optimalThreeSum(arr);

    }
}
