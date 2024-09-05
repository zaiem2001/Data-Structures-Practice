package Java.AtoZ.LinkedList;

public class ReverseKGroups {
    public static ListNode<Integer> findKthNode(ListNode<Integer> head, int k) {
        k--;

        while (head != null && k > 0) {
            k--;
            head = head.next;
        }

        return head;
    }

    public static ListNode<Integer> reverseKgroups(ListNode<Integer> head, int k) {
        if (head == null || k <= 1)
            return head;

        ListNode<Integer> temp = head;
        ListNode<Integer> prev = null;

        while (temp != null) {
            ListNode<Integer> kthNode = findKthNode(temp, k);

            if (kthNode == null) {
                if (prev != null)
                    prev.next = temp;
                break;
            }

            ListNode<Integer> next = kthNode.next;
            kthNode.next = null;
            Reverse.reverseList(temp);

            if (temp == head) {
                head = kthNode;
            } else {
                if (prev != null)
                    prev.next = kthNode;
            }
            prev = temp;
            temp = next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> ls = new ListNode<>(1);
        ls.next = new ListNode<>(2);
        ls.next.next = new ListNode<>(3);
        ls.next.next.next = new ListNode<>(4);
        ls.next.next.next.next = new ListNode<>(5);
        int k = 2;

        System.out.println(ls);
        System.out.println("After Reversing");
        System.out.println(reverseKgroups(ls, k));

    }
}
