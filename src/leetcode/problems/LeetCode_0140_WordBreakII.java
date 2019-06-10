package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 *
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */
@Deprecated
public class LeetCode_0140_WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        return run(s, wordDict);
    }

    public List<String> run(String s, List<String> wordDict) {
        ArrayList<String>[] tmp = new ArrayList[s.length()];
        return call(s, wordDict, 0, tmp);
    }

    public List<String> call(String s, List<String> wordDict, int start, List<String>[] cache) {
        List<String> result = new ArrayList<>();
        List<String> list = cache[start];
        if (list != null) {
            return list;
        }

        String word = null;
        String seprator = " ";
        for (int i = start + 1; i < s.length() + 1; i++) {
            if (isMatch(s, wordDict, start, i)) {
                word = s.substring(start, i);
                if (i == s.length()) {
                    result.add(word);
                } else {
                    list = call(s, wordDict, i, cache);
                    if (list != null && list.size() > 0) {
                        for (int k = 0; k < list.size(); k++) {
                            result.add(word + seprator + list.get(k));
                        }
                    }
                }
            }
        }

        cache[start] = result;
        return result;
    }

    private boolean isMatch(String s, List<String> wordDict, int beginIndex, int endIndex) {
        String word = s.substring(beginIndex, endIndex);
        return wordDict.contains(word);
    }

}
