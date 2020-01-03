package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * 17. Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * 1
 * 2 abc
 * 3 def
 * 4 ghi
 * 5 jkl
 * 6 mno
 * 7 pqrs
 * 8 tuv
 * 9 wxyz
 * 0
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
@Deprecated
public class LeetCode_0017 {

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        return run(digits);
    }

    public static List<String> run(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return results;
        }

        List<String> tmps = null;
        for (int i = 0; i < digits.length(); i++) {
            tmps = new ArrayList<>();
            String letters = KEYS[(digits.charAt(i) - '0')];
            for (int j = 0; j < letters.length(); j++) {
                if (results.size() == 0) {
                    tmps.add("" + letters.charAt(j));
                } else {
                    for (String result : results) {
                        tmps.add(result + letters.charAt(j));
                    }
                }
            }
            results = tmps;
        }
        return results;
    }

}
