import java.util.List;

public class SortList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static ListNode head;

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1. Cut the list to two halves and sort
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // Step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }

            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }

        if (l2 != null) {
            p.next = l2;
        }

        return l.next;
    }

    void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        SortList list = new SortList();
        list.head = new ListNode(2);
        list.head.next = new ListNode(1);
        list.head.next.next = new ListNode(-1);
        list.head.next.next.next = new ListNode(5);
        list.head.next.next.next.next = new ListNode(9);
        list.head.next.next.next.next.next = new ListNode(4);
        list.head.next.next.next.next.next.next = new ListNode(7);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.sortList(head);
        list.printList(head);
    }
}
