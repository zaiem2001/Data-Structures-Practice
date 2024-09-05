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

    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> output = new ListNode<Integer>(-1);
        ListNode<Integer> temp = output;

        ListNode<Integer> tempL1 = l1;
        ListNode<Integer> tempL2 = l2;
        int carry = 0;

        while (tempL1 != null || tempL2 != null) {
            int num = carry;
            if (tempL1 != null)
                num += tempL1.data;
            if (tempL2 != null)
                num += tempL2.data;

            carry = num / 10;
            temp.next = new ListNode<Integer>(num % 10);
            temp = temp.next;

            if (tempL1 != null)
                tempL1 = tempL1.next;
            if (tempL2 != null)
                tempL2 = tempL2.next;
        }

        if (carry == 1) {
            temp.next = new ListNode<Integer>(1);
        }

        return output.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> ls = new ListNode<>(9);
        ls.next = new ListNode<>(9);
        ls.next.next = new ListNode<>(9);
        ls.next.next.next = new ListNode<>(9);
        // ls.next.next.next.next = new ListNode<>(0);
        // ls.next.next.next.next.next = new ListNode<>(1);
        ListNode<Integer> ls2 = new ListNode<>(9);
        ls2.next = new ListNode<>(9);
        ls2.next.next = new ListNode<>(9);

        // System.out.println(addOne(ls));
        System.out.println(addTwoNumbers(ls, ls2));
        // System.out.println(addOne_recursive(ls));
    }
}
