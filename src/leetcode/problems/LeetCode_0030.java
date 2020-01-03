package leetcode.problems;

import java.util.*;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 * 30. Substring with Concatenation of All Words
 *
 * You are given a string, s, and a list of words,
 * words, that are all of the same length.
 *
 * Find all starting indices of substring(s) in s
 * that is a concatenation of each word in words exactly once
 * and without any intervening characters.
 *
 * Example 1:
 *
 * Input:
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 *
 * Input:
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * Output: []
 */
// todo
@Deprecated
public class LeetCode_0030 {

    public List<Integer> findSubstring(String s, String[] words) {
        return run(s, words);
    }

    public static List<Integer> run(String str, String[] words) {
        List<Integer> results = new ArrayList<>();
        if (words == null || words.length == 0) {
            return results;
        }

        int wordLength = words[0].length();
        Integer count = null;
        Map<String, Integer> countMap = new HashMap<>();
        for (int j = 0; j < words.length; j++) {
            count = countMap.get(words[j]);
            if (count == null) {
                count = 0;
            }
            count ++;
            countMap.put(words[j], count);
        }

        String word = null;
        int start = 0;
        int i = 0;
        int match = 0;
        Integer occur = 0;
        String empty = "";
        String[] wordArray = new String[str.length()];
        Map<String, Integer> occurMap = new HashMap<>();
        while ((words.length - match) * wordLength <= (str.length() - i)) {
            word = wordArray[i];
            if (word == null) {
                for (int j = 0; j < words.length; j++) {
                    if (isSubstring(str, i, words[j])) {
                        word = words[j];
                        break;
                    }
                }
                if (word == null) {
                    word = empty;
                }
                wordArray[i] = word;
            }

            if (word.length() == 0) {
                occurMap.clear();
                match = 0;
                start += 1;
                i = start;
                continue;
            }

            occur = occurMap.get(word);
            if (occur == null) {
                occur = 1;
            } else {
                occur ++;
            }
            count = countMap.get(word);
            if (occur <= count) {
                match ++;
                if (match == words.length) {
                    results.add(start);
                    occurMap.clear();
                    match = 0;
                    start += 1;
                    i = start;
                } else {
                    occurMap.put(word, occur);
                    i += wordLength;
                }
            }  else {
                occurMap.clear();
                match = 0;
                start += 1;
                i = start;
            }
        }

        return results;
    }

    private static boolean isSubstring(String str, int start, String sub) {
        for (int i = 0; i < sub.length(); i++) {
            if (i + start < str.length()) {
                if (sub.charAt(i) == str.charAt(i + start)) {
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    /**
     * @link https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13673/Accepted-Java-solution-12ms-with-explanation
     *
     * 滑动窗口思想
     */
    public static List<Integer> findSubstring2(String s, String[] words) {
        int N = s.length();
        List<Integer> indexes = new ArrayList<Integer>(s.length());
        if (words.length == 0) {
            return indexes;
        }
        int M = words[0].length();
        if (N < M * words.length) {
            return indexes;
        }
        int last = N - M + 1;

        //map each string in words array to some index and compute target counters
        Map<String, Integer> mapping = new HashMap<String, Integer>(words.length);
        int [][] table = new int[2][words.length];
        int failures = 0, index = 0;
        for (int i = 0; i < words.length; ++i) {
            Integer mapped = mapping.get(words[i]);
            if (mapped == null) {
                ++failures;
                mapping.put(words[i], index);
                mapped = index++;
            }
            ++table[0][mapped];
        }

        //find all occurrences at string S and map them to their current integer, -1 means no such string is in words array
        int [] smapping = new int[last];
        for (int i = 0; i < last; ++i) {
            String section = s.substring(i, i + M);
            Integer mapped = mapping.get(section);
            if (mapped == null) {
                smapping[i] = -1;
            } else {
                smapping[i] = mapped;
            }
        }

        //fix the number of linear scans
        for (int i = 0; i < M; ++i) {
            //reset scan variables
            int currentFailures = failures; //number of current mismatches
            int left = i, right = i;
            Arrays.fill(table[1], 0);
            //here, simple solve the minimum-window-substring problem
            while (right < last) {
                while (currentFailures > 0 && right < last) { // right of window
                    int target = smapping[right];
                    if (target != -1 && ++table[1][target] == table[0][target]) {
                        --currentFailures;
                    }
                    right += M;
                }
                while (currentFailures == 0 && left < right) { // left of window
                    int target = smapping[left];
                    if (target != -1 && --table[1][target] == table[0][target] - 1) {
                        int length = right - left;
                        //instead of checking every window, we know exactly the length we want
                        if ((length / M) ==  words.length) {
                            indexes.add(left);
                        }
                        ++currentFailures;
                    }
                    left += M;
                }
            }

        }
        return indexes;
    }

    public static List<Integer> run2(String str, String[] words) {
        List<Integer> results = new ArrayList<>();
        if (words == null || words.length == 0) {
            return results;
        }

        int wordLength = words[0].length();
        Integer count = null;
        Map<String, Integer> countMap = new HashMap<>();
        for (int j = 0; j < words.length; j++) {
            count = countMap.get(words[j]);
            if (count == null) {
                count = 0;
            }
            count ++;
            countMap.put(words[j], count);
        }

        String empty = "";
        String[] wordArray = new String[str.length()];
        Map<String, Integer> occurMap = new HashMap<>();

        String word = null;
        int left = 0;
        int right = 0;
        int match = 0;
        Integer occur = 0;

        for (int index = 0; index < wordLength; index++) {
            occurMap.clear();
            match = 0;
            left = index;
            right = left;
            while ((words.length - match) * wordLength <= (str.length() - right)) {
                word = wordArray[right];
                if (word == null) {
                    for (int j = 0; j < words.length; j++) {
                        if (isSubstring(str, right, words[j])) {
                            word = words[j];
                            break;
                        }
                    }
                    if (word == null) {
                        word = empty;
                    }
                    wordArray[right] = word;
                }

                if (word.length() == 0) {
                    occurMap.clear();
                    match = 0;
                    left = right + wordLength;
                    right = left;
                    continue;
                }

                occur = occurMap.get(word);
                if (occur == null) {
                    occur = 1;
                } else {
                    occur ++;
                }
                count = countMap.get(word);
                if (occur <= count) {
                    match ++;
                    occurMap.put(word, occur);
                    if (match == words.length) {
                        results.add(left);
                        // left of window
                        occur = occurMap.get(wordArray[left]);
                        occurMap.put(wordArray[left], occur - 1);
                        match --;
                        left += wordLength;
                    }
                }  else {
                    // left of window
                    while (true) {
                        if (word.equals(wordArray[left])) {
                            left += wordLength;
                            break;
                        }
                        occur = occurMap.get(wordArray[left]);
                        occurMap.put(wordArray[left], occur - 1);
                        match --;
                        left += wordLength;
                    }
                }
                right += wordLength;
            }
        }

        return results;
    }

}
