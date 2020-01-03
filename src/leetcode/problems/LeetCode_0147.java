package leetcode.problems;

import leetcode.shared.ListNode;

/**
 * https://leetcode.com/problems/insertion-sort-list/
 *
 * 147. Insertion Sort List
 *
 * Sort a linked list using insertion sort.
 *
 *
 * A graphical example of insertion sort.
 * The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 *
 *
 * Algorithm of Insertion Sort:
 *
 * Insertion sort iterates, consuming one input element each repetition,
 * and growing a sorted output list.
 *
 * At each iteration, insertion sort removes one element from the input data,
 * finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
@Deprecated
public class LeetCode_0147 {

    public ListNode insertionSortList(ListNode head) {
        return run(head);
    }

    public static ListNode run(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head.next;
        ListNode tail = head;
        ListNode cur = null;
        ListNode pre = null;
        while (node != null) {
            pre = null;
            cur = head;
            while (true) {
                if (cur == node) {
                    tail = node;
                    node = node.next;
                    break;
                }
                if (cur.val <= node.val) {
                    pre = cur;
                    cur = cur.next;
                } else {
                    if (pre == null) {
                        head = node;
                        node = node.next;
                        tail.next = node;
                        head.next = cur;
                    } else {
                        pre.next = node;
                        node = node.next;
                        tail.next = node;
                        pre.next.next = cur;
                    }
                    break;
                }
            }
        }

        return head;
    }

}
