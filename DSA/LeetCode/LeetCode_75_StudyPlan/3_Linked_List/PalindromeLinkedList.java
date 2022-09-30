import java.util.List;

public class PalindromeLinkedList {
    static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, mid = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // odd -> fast is not null
        if (fast != null) {
            mid = slow.next;
        } else {
            mid = slow;
        }

        ListNode prev = null, next = null;
        while (mid != null) {
            next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }

        while (prev != null) {
            if (prev.val != head.val) {
                return false;
            }

            prev = prev.next;
            head = head.next;
        }

        return true;
    }

    void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        PalindromeLinkedList list = new PalindromeLinkedList();
        list.head = new ListNode(85);
        list.head.next = new ListNode(15);
        list.head.next.next = new ListNode(4);
        list.head.next.next.next = new ListNode(20);
        list.head.next.next.next.next = new ListNode(30);

        System.out.println("Given Linked list");
        list.printList(head);
        System.out.println(list.isPalindrome(head));
    }
}
