package leetcode.problems;

import leetcode.shared.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list,
 * we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 *
 *
 *
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LeetCode_0142_LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        return run(head);
    }

    public ListNode run(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode nodeStep1 = head;
        ListNode nodeStep2 = head;
        ListNode nodeStart = null;
        int index = 0;
        map.put(head, index);
        while (true) {
            if (nodeStep1 != null) {
                nodeStep1 = nodeStep1.next;
                index ++;
                if (nodeStart == null) {
                    if (map.containsKey(nodeStep1)) {
                        nodeStart = nodeStep1;
                    } else {
                        map.put(nodeStep1, index);
                    }
                }
            }

            if (nodeStep2 != null) {
                nodeStep2 = nodeStep2.next;
            }

            if (nodeStep2 != null) {
                nodeStep2 = nodeStep2.next;
            }

            if (nodeStep1 == null || nodeStep2 == null) {
                return null;
            }

            if (nodeStep1 == nodeStep2) {
                if (nodeStart != null) {
                    return nodeStart;
                }
            }
        }
    }

    //https://leetcode.com/problems/linked-list-cycle-ii/discuss/44774/Java-O(1)-space-solution-with-detailed-explanation.
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                ListNode slow2 = head;
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

}
