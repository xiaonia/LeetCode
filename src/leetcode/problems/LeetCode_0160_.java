package leetcode.problems;

import leetcode.shared.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * 160. Intersection of Two Linked Lists
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 *
 * begin to intersect at node c1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 *
 *
 * Example 2:
 *
 *
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 *
 *
 * Example 3:
 *
 *
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 *
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class LeetCode_0160_ {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) {
            return null;
        }

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( nodeA != nodeB){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            nodeA = nodeA == null? headB : nodeA.next;
            nodeB = nodeB == null? headA : nodeB.next;
        }

        return nodeA;
    }

    public static ListNode run(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new HashMap<>();
        int countA = 0;
        int countB = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        ListNode node = null;
        while (true) {
            if (nodeA == null && nodeB == null) {
                break;
            }

            if (nodeA != null) {
                if (map.get(nodeA) != null) {
                    node = nodeA;
                    break;
                }
                map.put(nodeA, countA);
                nodeA = nodeA.next;
                countA ++;
            }

            if (nodeB != null) {
                if (map.get(nodeB) != null) {
                    node = nodeB;
                    break;
                }
                map.put(nodeB, countB);
                nodeB = nodeB.next;
                countB ++;
            }
        }
        return node;
    }

}