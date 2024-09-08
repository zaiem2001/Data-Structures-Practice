package Java.AtoZ.Recursion;

import java.util.Stack;

public class ReverseStack {
    static void insert_bottom(Stack<Integer> s, int temp) {
        if (s.size() == 0) {
            s.push(temp);
        } else {
            int x = s.peek();
            s.pop();
            insert_bottom(s, temp);
            s.push(x);
        }
    }

    static void reverse(Stack<Integer> s) {
        if (s.size() > 0) {
            int x = s.peek();
            s.pop();
            reverse(s);
            insert_bottom(s, x);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        System.out.println(s);
        System.out.println("After reversing...");

        reverse(s);
        System.out.println(s);
    }
}
