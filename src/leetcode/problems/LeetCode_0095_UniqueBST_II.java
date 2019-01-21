package leetcode.problems;

import leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n. */

/*

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
@Deprecated
public class LeetCode_0095_UniqueBST_II {

    public List<TreeNode> generateTrees(int n) {
        return uniqueBST(n);
    }

    public List<TreeNode> uniqueBST(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> list = null;

        list = new ArrayList<>();
        list.add(null);
        map.put(0, list);
        list = new ArrayList<>();
        list.add(new TreeNode(1));
        map.put(1, list);

        int index = 2;
        while (index <= n) {
            list = new ArrayList<>();
            int k = 1;
            TreeNode root;
            List<TreeNode> leftList;
            List<TreeNode> rightList;
            while (k <= index) {
                leftList = map.get(k - 1);
                rightList = map.get(index - k);
                for (TreeNode left : leftList) {
                    for (TreeNode right : rightList) {
                        root = new TreeNode(k);
                        root.left = left;
                        root.right = copyTreeNode(right, k);
                        list.add(root);
                    }
                }
                k++;
            }
            map.put(index, list);
            index ++;
        }
        return map.get(n);
    }

    public static TreeNode copyTreeNode(TreeNode root, int offset) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val + offset);
        node.left = copyTreeNode(root.left, offset);
        node.right = copyTreeNode(root.right, offset);
        return node;
    }

}
