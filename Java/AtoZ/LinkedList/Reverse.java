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

    public static ListNode<Integer> reverse_recursive(ListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list

        ListNode<Integer> newHead = reverseList(head.next);

        // Reverse the current node's pointer
        head.next.next = head;
        head.next = null;

        // Return the new head of the reversed list
        return newHead;
    }
}
