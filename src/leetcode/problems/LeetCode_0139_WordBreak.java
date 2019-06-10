package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
@Deprecated
public class LeetCode_0139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return run(s, wordDict);
    }

    public boolean run(String s, List<String> wordDict) {
        Map<Integer, Integer> mapCache = new HashMap<>();
        return call(s, wordDict, 0, mapCache);
    }

    public boolean call(String s, List<String> wordDict, int start, Map<Integer, Integer> mapCache) {
        Integer value = mapCache.get(start);
        if (value != null) {
            return value > 0;
        }

        for (int i = start + 1; i < s.length() + 1; i++) {
            if (isMatch(s, wordDict, start, i)
                    && (i == s.length() || call(s, wordDict, i, mapCache))) {
                mapCache.put(start, 1);
                return true;
            } else {
                mapCache.put(start, 0);
            }
        }
        return false;
    }

    public boolean isMatch(String s, List<String> wordDict, int beginIndex, int endIndex) {
        String word = s.substring(beginIndex, endIndex);
        return wordDict.contains(word);
    }

}
