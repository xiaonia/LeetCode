package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively. */
@Deprecated
public class LeetCode_0087_ScrambleString {

    public static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        /*int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }*/

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0,i), s2.substring(0,i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }

            if (isScramble(s1.substring(0,i), s2.substring(s2.length()-i))
                    && isScramble(s1.substring(i), s2.substring(0,s2.length()-i))) {
                return true;
            }
        }

        return false;
    }

    /*public static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }


        Map<String, List<String>> map = new HashMap<>();
        List<String> list = scrambleString(s1, map);
        return list.contains(s2);
    }*/

    //time out
    public static List<String> scrambleString(String input, Map<String, List<String>> map) {
        List<String> list = map.get(input);
        if (list != null) {
            return list;
        }

        list = new ArrayList<>();
        if (input.length() < 2) {
            list.add(input);
            return list;
        }

        String preKey = null;
        String sufKey = null;
        for (int i = 1; i < input.length(); i++) {
            preKey = input.substring(0, i);
            List<String> preList = map.get(preKey);
            if (preList == null) {
                preList = scrambleString(preKey, map);
            }

            sufKey = input.substring(i, input.length());
            List<String> sufList = map.get(sufKey);
            if (sufList == null) {
                sufList = scrambleString(sufKey, map);
            }

            for (String aPreList : preList) {
                for (String aSufList : sufList) {
                    list.add(aPreList + aSufList);
                    list.add(aSufList + aPreList);
                }
            }
        }

        map.put(input, list);
        return list;
    }

}
