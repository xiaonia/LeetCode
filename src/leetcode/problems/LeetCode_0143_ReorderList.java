package leetcode.problems;

import leetcode.shared.ListNode;

import java.util.Stack;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
@Deprecated
public class LeetCode_0143_ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        Stack<ListNode> nodeStack = new Stack<>();
        ListNode mid = head;
        ListNode node = head.next;
        while (node != null) {
            mid = mid.next;
            node = node.next;
            if (node != null) {
                node = node.next;
            }
        }

        node = mid;
        while (node != null) {
            nodeStack.push(node);
            node = node.next;
        }
        if (nodeStack.empty()) {
            return;
        }

        ListNode tmp = null;
        ListNode cur = head;
        while (!nodeStack.empty()) {
            node = nodeStack.pop();
            if (cur == node || cur.next == node) {
                node.next = null;
                break;
            }
            tmp = cur.next;
            cur.next = node;
            node.next = tmp;
            cur = tmp;
        }
    }

}
