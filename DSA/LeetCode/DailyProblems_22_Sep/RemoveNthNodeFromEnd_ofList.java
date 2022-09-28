import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveNthNodeFromEnd_ofList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return start.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(85);
        list.next = new ListNode(15);
        list.next.next = new ListNode(4);
        list.next.next.next = new ListNode(20);
        list.next.next.next.next = new ListNode(30);

        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();

        System.out.println("Given Linked List");
        printList(list);
        System.out.println();

        list = removeNthFromEnd(list, n);
        printList(list);
        System.out.println();

        scr.close();
    }
}
