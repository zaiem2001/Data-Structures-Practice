package Java.AtoZ.StackNQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreater {
    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        Stack<Integer> myStack = new Stack<>();
        HashMap<Integer, Integer> myHashMap = new HashMap<>();

        buildHashMap(nums2, myStack, myHashMap);

        for (int i = 0; i < nums1.length; i++) {
            res[i] = myHashMap.get(nums1[i]);
        }

        return res;
    }

    private static void buildHashMap(int[] nums2, Stack<Integer> myStack, HashMap<Integer, Integer> myHashMap) {
        for (int i = nums2.length - 1; i >= 0; i--) {
            int currVal = nums2[i];
            if (myStack.isEmpty()) {
                myHashMap.put(currVal, -1);
            } else {
                while (!myStack.isEmpty() && currVal > myStack.peek()) {
                    myStack.pop();
                }
                myHashMap.put(currVal, myStack.isEmpty() ? -1 : myStack.peek());
            }
            myStack.push(currVal);
        }
    }

    // Circular array
    static int[] nextGreaterElementII(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if (n == 1) {
            return new int[] { -1 };
        }
        Stack<Integer> myStack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;
            int currVal = nums[idx];

            while (!myStack.isEmpty() && currVal >= myStack.peek()) {
                myStack.pop();
            }

            res[idx] = myStack.isEmpty() ? -1 : myStack.peek();
            myStack.push(currVal);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 4, 1 };
        int[] nums2 = { 1, 2, 3, 4, 6 };

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
        System.out.println(Arrays.toString(nextGreaterElementII(new int[] { 1, 2, 3, 4, 3 })));
    }
}
