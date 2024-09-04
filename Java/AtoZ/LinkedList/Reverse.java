package Java.AtoZ.LinkedList;

public class Reverse {
    public static ListNode<Integer> reverseList(ListNode<Integer> head) {
        if (head == null || head.next == null)
            return head;

        ListNode<Integer> prev = null;
        ListNode<Integer> current = head;
        ListNode<Integer> temp = null;

        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }
}
