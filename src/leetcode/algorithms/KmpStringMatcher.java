package leetcode.algorithms;

import leetcode.utils.DebugUtils;

import java.util.ArrayList;
import java.util.List;

public class KmpStringMatcher {

    public static void main(String[] args) {
        DebugUtils.print(findMatchString("tobeornottobe", "ob"));
    }

    public static List<Integer> findMatchString(String origin, String pattern) {
        List<Integer> list = new ArrayList<>();
        if (origin.length() < pattern.length()) {
            return list;
        }

        int[] partialMatchTable = buildPartialMatchTable(pattern);

        int patternEnd = 0;
        int originEnd = 0;
        int originLength = origin.length();
        int patternLength = pattern.length();
        while (originEnd < originLength - (patternLength - patternEnd)) {
            while (patternEnd < pattern.length()
                    && origin.charAt(originEnd) == pattern.charAt(patternEnd)
            ) {
                originEnd ++;
                patternEnd ++;
            }

            if (patternEnd == 0) {
                originEnd ++;
            } else {
                if (patternEnd == pattern.length()) {
                    list.add(originEnd - pattern.length());
                }
                patternEnd = partialMatchTable[patternEnd - 1];
            }
        }

        return list;
    }

    public static int[] buildPartialMatchTable(String pattern) {
        if (pattern.length() == 0) {
            return new int[0];
        }

        int[] partialMatchTable = new int[pattern.length()];
        partialMatchTable[0] = 0;
        for (int i = 1; i < pattern.length(); i++) {
            buildPartialMatchTable(pattern, partialMatchTable, i);
        }
        return partialMatchTable;
    }

    private static void buildPartialMatchTable(String pattern, int[] table, int index) {
        if (index >= pattern.length()) {
            return;
        }

        int lastMatchIndex = index - 1;
        while (lastMatchIndex >= 0) {
            if (pattern.charAt(table[lastMatchIndex]) == pattern.charAt(index)) {
                table[index] = table[lastMatchIndex] + 1;
                break;
            }

            if (lastMatchIndex == 0) {
                table[index] = 0;
                break;
            }

            lastMatchIndex = table[lastMatchIndex];
        }
    }

}
