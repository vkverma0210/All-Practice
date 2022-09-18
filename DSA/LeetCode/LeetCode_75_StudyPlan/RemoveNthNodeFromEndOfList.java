import java.util.Scanner;

public class RemoveNthNodeFromEndOfList {
    static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        // Move fast in front n + 1 so that the gap between slow and fast becomes n
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        // Move fast to the end , maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList list = new RemoveNthNodeFromEndOfList();
        list.head = new ListNode(85);
        list.head.next = new ListNode(15);
        list.head.next.next = new ListNode(4);
        list.head.next.next.next = new ListNode(20);
        list.head.next.next.next.next = new ListNode(30);

        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.removeNthFromEnd(head, n);
        list.printList(head);
    }
}
