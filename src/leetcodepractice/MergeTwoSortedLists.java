package leetcodepractice;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(-1); //fake node
        ListNode tail = temp; // helps to build the new list
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 == null) ? list2 : list1;

        return temp.next;
    }


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static ListNode buildList(MergeTwoSortedLists solution, int[] values) {
        ListNode dummy = solution.new ListNode(-1);
        ListNode current = dummy;

        for (int v : values) {
            current.next = solution.new ListNode(v);
            current = current.next;
        }
        return dummy.next;
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode list1 = buildList(solution, new int[]{1, 2, 4});
        ListNode list2 = buildList(solution, new int[]{1, 3, 4});
        ListNode result = solution.mergeTwoLists(list1, list2);
        printList(result);
    }
}
