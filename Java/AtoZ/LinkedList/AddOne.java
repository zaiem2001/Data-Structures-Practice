package Java.AtoZ.LinkedList;

public class AddOne {
    public static int helper(ListNode<Integer> temp) {
        if (temp == null)
            return 1;

        int carry = helper(temp.next);
        temp.data = carry + temp.data;

        if (temp.data < 10) {
            return 0;
        }

        temp.data = 0;
        return 1;
    }

    public static ListNode<Integer> addOne_recursive(ListNode<Integer> head) {
        if (head == null)
            return head;

        int carry = helper(head);

        if (carry == 1) {
            ListNode<Integer> newNode = new ListNode<>(1);
            newNode.next = head;
            return newNode;
        }

        return head;
    }

    public static ListNode<Integer> addOne(ListNode<Integer> head) {
        if (head == null)
            return head;

        int carry = 1;
        head = Reverse.reverseList(head);

        ListNode<Integer> temp = head;

        while (temp != null && carry != 0) {
            int number = carry + temp.data;
            carry = number == 10 ? 1 : 0;
            temp.data = carry == 1 ? 0 : number;
            temp = temp.next;
        }

        head = Reverse.reverseList(head);

        if (carry == 1) {
            ListNode<Integer> newNode = new ListNode<>(1);
            newNode.next = head;
            return newNode;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> ls = new ListNode<>(9);
        ls.next = new ListNode<>(9);
        ls.next.next = new ListNode<>(9);
        // ls.next.next.next = new ListNode<>(9);
        // ls.next.next.next.next = new ListNode<>(0);
        // ls.next.next.next.next.next = new ListNode<>(1);

        System.out.println(addOne(ls));
        System.out.println(addOne_recursive(ls));
    }
}
