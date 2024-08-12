package Java.AtoZ.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Foursum {
    public static void frSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;

                int k = j + 1;
                int l = nums.length - 1;

                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        Integer[] tempArr = { nums[i], nums[j], nums[k], nums[l] };
                        result.add(Arrays.asList(tempArr));
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, -5, -2, -2, -4, 0, 1, -2 };
        int target = -9;
        frSum(arr, target);
    }
}
