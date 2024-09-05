package Java.AtoZ.LinkedList;

public class RotateList {
    public static ListNode<Integer> rotate(ListNode<Integer> head, int k) {
        if (head == null && k == 0)
            return head;

        ListNode<Integer> temp = head;
        int length = 1;
        ListNode<Integer> tail = head;

        while (tail.next != null) {
            length++;
            tail = tail.next;
        }

        k = k % length;

        if (k == 0)
            return head;

        int r = length - k - 1;

        while (r != 0) {
            temp = temp.next;
            r--;
        }

        tail.next = head;
        head = temp.next;
        temp.next = null;

        return head;

    }

    public static void main(String[] args) {
        ListNode<Integer> ls = new ListNode<>(1);
        ls.next = new ListNode<>(2);
        ls.next.next = new ListNode<>(3);
        ls.next.next.next = new ListNode<>(4);
        // ls.next.next.next.next = new ListNode<>(5);
        int k = 198;

        System.out.println(ls);
        System.out.println("After rotating...");
        System.out.println(rotate(ls, k));

    }
}
