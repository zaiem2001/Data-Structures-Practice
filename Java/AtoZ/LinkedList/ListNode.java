package Java.AtoZ.LinkedList;

import java.util.ArrayList;

public class ListNode<T> {
    T data;
    ListNode<T> next;

    ListNode(T data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        ListNode<T> node = this;
        ArrayList<T> arr = new ArrayList<T>();

        while (node != null) {
            arr.add(node.data);
            node = node.next;
        }

        return arr.toString();
    }
}
