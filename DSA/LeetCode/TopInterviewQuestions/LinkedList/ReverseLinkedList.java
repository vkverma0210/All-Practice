class ReverseLinkedList {
    static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    ListNode reverseList_Iterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    ListNode reverseList_Recursive(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newNode = reverseList_Recursive(head.next);
        ListNode headNext = head.next;

        headNext.next = head;
        head.next = null;

        return newNode;
    }

    void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new ListNode(85);
        list.head.next = new ListNode(15);
        list.head.next.next = new ListNode(4);
        list.head.next.next.next = new ListNode(20);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverseList_Iterative(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);

        head = list.reverseList_Recursive(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }
}
