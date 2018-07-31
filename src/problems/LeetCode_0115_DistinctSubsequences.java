package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * A subsequence of a string is a new string which is formed from the original string
 * by deleting some (can be none) of the characters without disturbing the relative positions
 * of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Example 1:
 *
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 *
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * Example 2:
 *
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 *
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 */
//TODO
public class LeetCode_0115_DistinctSubsequences {

    public int numDistinct(String s, String t) {
        return run(s, t);
    }

    public static int run(String s, String t) {
        if (t == null || "".equals(t)) {
            return 0;
        }

        int[] tmp = new int[t.length() + 1];
        tmp[0] = 1;

        char tChar = 0;
        char sChar = 0;
        for (int i = 0; i < s.length(); i++) {
            sChar = s.charAt(i);
            if (t.indexOf(sChar) < 0) {
                continue;
            }

            for (int j = t.length() - 1; j >= 0 ; j--) {
                tChar = t.charAt(j);
                if (sChar == tChar) {
                    tmp[j + 1] += tmp[j];
                }
            }
        }

        return tmp[t.length()];
    }

    public static List<Integer> call(String s, String t, int index) {
        List<Integer> result = new ArrayList<>();
        char tChar = t.charAt(index);
        char sChar = 0;

        if (index == 0) {
            for (int i = 0; i < s.length(); i++) {
                sChar = s.charAt(i);
                if (sChar == tChar) {
                    result.add(i);
                }
            }
        }
        else {
            List<Integer> preResult = call(s, t, index - 1);
            for (Integer preIndex : preResult) {
                for (int i = preIndex + 1; i < s.length(); i++) {
                    sChar = s.charAt(i);
                    if (sChar == tChar) {
                        result.add(i);
                    }
                }
            }
        }

        return result;
    }

    /*public static int run(String s, String t) {
        if (t == null || "".equals(t)) {
            return 0;
        }

        List<List<Integer>>[] tmp = new ArrayList[t.length()];
        return call(s, t, tmp, t.length() - 1);
    }

    public static int call(String s, String t, List<List<Integer>>[] tmp, int index) {
        if (index < 0) { //nope
            return 0;
        }
        if (tmp[index] != null) {
            return tmp[index].size();
        }

        List<List<Integer>> result = new ArrayList<>();
        char tChar = t.charAt(index);
        char sChar = 0;

        if (index == 0) {
            for (int i = 0; i < s.length(); i++) {
                sChar = s.charAt(i);
                if (sChar == tChar) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    result.add(list);
                }
            }
        }
        else {
            int size = call(s, t, tmp, index - 1);
            if (size > 0) {
                List<List<Integer>> preResult = tmp[index - 1];
                for (List<Integer> preList : preResult) {
                    for (int i = preList.get(preList.size() - 1) + 1; i < s.length(); i++) {
                        sChar = s.charAt(i);
                        if (sChar == tChar) {
                            List<Integer> list = new ArrayList<>(preList);
                            list.add(i);
                            result.add(list);
                        }
                    }
                }
            }
        }

        tmp[index] = result;
        return tmp[index].size();
    }*/

}
