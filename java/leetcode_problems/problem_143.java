package leetcode_problems;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class problem_143 {
    public static class ListNode {
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

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode next_node = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next_node;
        }
        return prev;
    }

    public void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;

            l1.next = l2;

            // nullity breaks the loop :
            if (l1_next == null) {
                break;
            }

            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
    }

    public void reorderList(ListNode head) {
        // for a linked list: l0, l1, ... , l_n-1, l_n
        // return the linked list: l0, l_n, l1, l_n-1, l2, l_n-2...
        // first, last, second ,second last, third, third last...

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null;
        // split at the halfway point
        // 1 -> 2 -> 3 -> 4 -> null
        // 5 -> 6 -> 7 -> 8 -> null // reverse this , then alternate between both sub-linked lists to construct the "re-ordered list"

        if (head == null || head.next == null) {
            return;
        }

        // head of first half
        ListNode l1 = head;

        // head of second half
        ListNode slow = head;

        // tail of second half
        ListNode fast = head;

        // tail of first half
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode l2 = reverseList(slow);

        // construct new linked list from both detached "sub-linked lists"
        merge(l1, l2);

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        problem_143 obj = new problem_143();
        obj.reorderList(head);
    }
}
