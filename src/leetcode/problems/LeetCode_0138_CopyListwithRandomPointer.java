package leetcode.problems;

import leetcode.shared.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 */
@Deprecated
public class LeetCode_0138_CopyListwithRandomPointer {

    public static class Node {

        public int val;

        public Node next;

        public Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        return run(head);
    }

    public static Node run(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        return copyNode(head, map);
    }

    private static Node copyNode(Node node, Map<Node, Node> map) {
        if (node == null) {
            return null;
        }

        Node copyNode = map.get(node);
        if (copyNode == null) {
            copyNode = new Node(node.val);
            map.put(node, copyNode);
            copyNode.next = copyNode(node.next, map);
            copyNode.random = copyNode(node.random, map);
        }
        return copyNode;
    }

}
