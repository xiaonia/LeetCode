package problems;

/** Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n? */
/*
Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
@Deprecated
public class LeetCode_0096_UniqueBST {

    public static int numTrees(int n) {
        if (n < 1) {
            return 0;
        }

        int[] tmp = new int[n + 1];
        tmp[0] = 1;
        tmp[1] = 1;
        int index = 2;
        while (index <= n) {
            tmp[index] = 0;
            int count = 0;
            while (count < index) {
                tmp[index] += tmp[index - count - 1] * tmp[count];
                count++;
            }
            index ++;
        }

        return tmp[n];
    }

}
