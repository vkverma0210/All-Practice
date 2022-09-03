class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class SinglyLinkedList {
    ListNode head;

    public void addToTheLast(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;

            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    void printList() {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();
    }
}

class MergeTwoSortedLists {
    ListNode mergeTwoLists_iteravtive(ListNode list1, ListNode list2) {
        // iterative
        if (list1 == null)
            return list2;

        if (list2 == null)
            return list1;

        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        ListNode res = list1;
        while (list1 != null && list2 != null) {
            ListNode temp = null;

            while (list1 != null && list1.val <= list2.val) {
                temp = list1;
                list1 = list1.next;
            }

            temp.next = list2;

            // swap
            ListNode tmp = list1;
            list1 = list2;
            list2 = tmp;
        }

        return res;
    }

    ListNode mergeTwoLists_Recursive(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;

        if (list2 == null)
            return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists_Recursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists_Recursive(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.addToTheLast(new ListNode(1));
        list1.addToTheLast(new ListNode(5));
        list1.addToTheLast(new ListNode(10));

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.addToTheLast(new ListNode(1));
        list2.addToTheLast(new ListNode(2));
        list2.addToTheLast(new ListNode(5));
        list2.addToTheLast(new ListNode(8));
        list2.addToTheLast(new ListNode(20));

        System.out.println("Given Linked list1");
        list1.printList();

        System.out.println("Given Linked list2");
        list2.printList();

        SinglyLinkedList list = new SinglyLinkedList();
        list.head = new MergeTwoSortedLists().mergeTwoLists_Recursive(list1.head, list2.head);

        System.out.println("");
        System.out.println("Merged linked list ");
        list.printList();
    }
}