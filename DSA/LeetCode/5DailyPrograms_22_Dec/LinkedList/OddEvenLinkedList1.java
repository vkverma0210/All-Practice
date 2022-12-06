class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class OddEvenLinkedList1 {
    public static ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode odd = head, even = head.next, evenhead = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }

            odd.next = evenhead;
        }

        return head;
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(2);
        list.next = new ListNode(1);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(5);
        list.next.next.next.next = new ListNode(6);
        list.next.next.next.next.next = new ListNode(4);
        list.next.next.next.next.next.next = new ListNode(7);

        System.out.println("Given Linked list");
        printList(list);
        ListNode head = oddEvenList(list);
        printList(head);
    }
}
