public class LinkedListCycleII {
    static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        if (fast == null || fast.next == null)
            return null;

        while (head != slow) {
            head = head.next;
            slow = slow.next;
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
        LinkedListCycleII list = new LinkedListCycleII();
        list.head = new ListNode(85);
        list.head.next = new ListNode(15);
        list.head.next.next = new ListNode(4);
        list.head.next.next.next = new ListNode(20);
        list.head.next.next.next.next = new ListNode(30);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.detectCycle(head);
        if (head == null) {
            System.out.println("-1");
        } else {
            System.out.println(head.val);
        }
    }
}
