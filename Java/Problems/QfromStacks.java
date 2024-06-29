package Java.Problems;

import java.util.Stack;

public class QfromStacks<T> {
    Stack<T> myStack1 = new Stack<>();
    Stack<T> myStack2 = new Stack<>();

    public T enqueue(T element) {
        myStack1.add(element);
        return element;
    }

    public T dequeue() {
        while (!myStack1.isEmpty()) {
            myStack2.add(myStack1.pop());
        }

        T topEl = myStack2.pop();

        while (!myStack2.isEmpty()) {
            myStack1.add(myStack2.pop());
        }

        return topEl;
    }

    public T peek() {
        while (!myStack1.isEmpty()) {
            myStack2.add(myStack1.pop());
        }

        T topEl = myStack2.peek();

        while (!myStack2.isEmpty()) {
            myStack1.add(myStack2.pop());
        }

        return topEl;
    }

    @Override
    public String toString() {
        return myStack1.toString();
    }

}
