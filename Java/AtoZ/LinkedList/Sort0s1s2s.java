package Java.AtoZ.LinkedList;

public class Sort0s1s2s {
    public static ListNode<Integer> sort0s1s2s(ListNode<Integer> head) {
        if (head == null || head.next == null)
            return head;

        ListNode<Integer> zeroHead = new ListNode<Integer>(-1);
        ListNode<Integer> zeroTemp = zeroHead;
        ListNode<Integer> oneHead = new ListNode<Integer>(-1);
        ListNode<Integer> oneTemp = oneHead;
        ListNode<Integer> twoHead = new ListNode<Integer>(-1);
        ListNode<Integer> twoTemp = twoHead;

        ListNode<Integer> temp = head;

        while (temp != null) {
            int data = temp.data;

            if (data == 0) {
                zeroTemp.next = temp;
                zeroTemp = temp;
            } else if (data == 1) {
                oneTemp.next = temp;
                oneTemp = temp;
            } else {
                twoTemp.next = temp;
                twoTemp = temp;
            }

            temp = temp.next;
        }

        zeroTemp.next = oneHead.next != null ? oneHead.next : twoHead.next;
        oneTemp.next = twoHead.next;
        twoTemp.next = null;

        return zeroHead.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> ls = new ListNode<>(1);
        ls.next = new ListNode<>(2);
        ls.next.next = new ListNode<>(1);
        ls.next.next.next = new ListNode<>(1);
        ls.next.next.next.next = new ListNode<>(0);
        ls.next.next.next.next.next = new ListNode<>(1);

        ListNode<Integer> head = sort0s1s2s(ls);
        System.out.println(head);
    }

}