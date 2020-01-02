package leetcode.problems;

/**
 * https://leetcode.com/problems/interleaving-string/
 *
 * 97. Interleaving String
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 *
 * 动态规划DP
 */
@Deprecated
public class LeetCode_0097_InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        return run(s1, s2, s3);
    }

    public static boolean run(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        if (s3.length() == 0) {
            return true;
        }

        int[][] tmp = new int[s1.length() + 1][s2.length() + 1];
        return isInterleave(tmp, s1, s2, s3, 0, 0);
    }

    public static boolean isInterleave(int[][] tmp,
                                       String str1, String str2, String str3,
                                       int index1, int index2) {

        int state = tmp[index1][index2];
        if (state < 0) {
            return false;
        }
        if (state > 0) {
            return true;
        }

        int index3 = index1 + index2;
        /*
        if (index3 >= str3.length()) {
            return false;
        } //*/

        if (index1 < str1.length()
                && str3.charAt(index3) == str1.charAt(index1)) {
            if (index3 == str3.length() - 1
                    || isInterleave(tmp, str1, str2, str3, index1 + 1, index2)) {
                tmp[index1][index2] = 1;
                return true;
            }
        }

        if (index2 < str2.length()
                && str3.charAt(index3) == str2.charAt(index2)) {
            if (index3 == str3.length() - 1
                    || isInterleave(tmp, str1, str2, str3, index1, index2 + 1)) {
                tmp[index1][index2] = 1;
                return true;
            }
        }

        tmp[index1][index2] = -1;
        return false;
    }

    public boolean isInterleaveII(String s1, String s2, String s3) {

        if ((s1.length() + s2.length()) != s3.length()) return false;

        boolean[][] matrix = new boolean[s2.length() + 1][s1.length() + 1];

        matrix[0][0] = true;

        for (int i = 1; i < matrix[0].length; i++){
            matrix[0][i] = matrix[0][i - 1] && (s1.charAt(i - 1) == s3.charAt( i - 1));
        }

        for (int i = 1; i < matrix.length; i++){
            matrix[i][0] = matrix[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                matrix[i][j] =
                        (matrix[i - 1][j] && (s2.charAt(i - 1) == s3.charAt(i + j - 1)))
                        || (matrix[i][j - 1] && (s1.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }

        return matrix[s2.length()][s1.length()];

    }

}
