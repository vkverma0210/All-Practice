import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class PalindromeLinkedList {
    ListNode head;

    public void insertAtLast(int data) {
        // Making a new node
        ListNode newNode = new ListNode(data);
        // if this is the first node
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = null;

        // if it's not the first node, then traverse the
        // complete linked list till the end
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // A utility function to print the linked list
    public void printList(ListNode head) {
        System.out.println("Printing the linked list");
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public boolean isPalindrome(ListNode head) {
        ListNode sp = head, fp = head, mid = null;

        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }

        // odd -> fp is not null
        if (fp != null) {
            mid = sp.next;
        } else {
            mid = sp;
        }

        ListNode prev = null, next = null;
        while (mid != null) {
            next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }

        while (prev != null) {
            if (prev.val != head.val)
                return false;
            prev = prev.next;
            head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList ll = new PalindromeLinkedList();
        ll.head = new ListNode(1);
        ll.insertAtLast(2);
        ll.insertAtLast(1);
        ll.insertAtLast(2);
        ll.insertAtLast(1);

        ll.printList(ll.head);

        if (ll.isPalindrome(ll.head)) {
            System.out.println("True Palindrome Linked List");
        } else {
            System.out.println("False Not a Palindrome Linked List");
        }
    }
}