public class OddEvenLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static ListNode head;

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

    void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        OddEvenLinkedList list = new OddEvenLinkedList();
        list.head = new ListNode(2);
        list.head.next = new ListNode(1);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(5);
        list.head.next.next.next.next = new ListNode(6);
        list.head.next.next.next.next.next = new ListNode(4);
        list.head.next.next.next.next.next.next = new ListNode(7);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.oddEvenList(head);
        list.printList(head);
    }
}
