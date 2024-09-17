package Java.AtoZ.StackNQueue;

import java.util.Arrays;
import java.util.Stack;

public class Asteroid {
    static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> myStack = new Stack<>();
        int n = asteroids.length;

        for (int i = n - 1; i >= 0; i--) {
            int elem = asteroids[i];
            boolean keepCurrent = true;
            if (elem < 0) {
                myStack.push(elem);
            } else {
                while (!myStack.isEmpty() && myStack.peek() < 0) {
                    if (Math.abs(myStack.peek()) < elem) {
                        myStack.pop();
                    } else if (Math.abs(myStack.peek()) == elem) {
                        myStack.pop();
                        keepCurrent = false;
                    } else {
                        keepCurrent = false;
                        break;
                    }
                }
                if (keepCurrent) {
                    myStack.push(elem);
                }
            }
        }

        if (myStack.isEmpty()) {
            return new int[] {};
        }
        int size = myStack.size();
        int[] res = new int[size];

        for (int i = 0; i < size; i++) {
            res[i] = myStack.peek();
            myStack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] asteroids = { 5, 15, -10, -20, 22 };
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }
}
