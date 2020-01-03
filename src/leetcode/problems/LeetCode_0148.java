package leetcode.problems;

import leetcode.shared.ListNode;

/**
 * https://leetcode.com/problems/sort-list/
 *
 * 148. Sort List
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
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
// @todo
@Deprecated
public class LeetCode_0148 {

    public ListNode sortList(ListNode head) {
        return run(head);
    }

    public static ListNode run(ListNode head) {
        return mergeSort(head);
    }

    public static ListNode fastSort(ListNode head, ListNode tail) {
        if (head == tail) {
            return head;
        }

        ListNode middle = head;
        ListNode pre = middle;
        ListNode cur = middle.next;
        int count = 1;
        while (cur != null && cur != tail) {
            if (middle.val >= cur.val) {
                pre.next = cur.next;
                cur.next = head;
                head = cur;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
            count ++;
        }

        if (count <= 2) {
            return head;
        }
        middle.next = fastSort(middle.next, tail);
        return fastSort(head, middle);
    }

    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // step 1. cut the list to two halves
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = null;
        }

        // step 2. sort each half
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(slow);

        // step 3. merge l1 and l2
        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode tail = head;

        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if (left != null) {
            tail.next = left;
        }

        if (right != null) {
            tail.next = right;
        }

        return head.next;
    }


}
