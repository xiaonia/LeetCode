package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 *
 * 187. Repeated DNA Sequences
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
@Deprecated
public class LeetCode_0187 {

    public List<String> findRepeatedDnaSequences(String s) {
        return run(s);
    }

    public static List<String> run(String s) {
        List<String> list = new ArrayList<>();
        int length = 10;
        if (s == null || s.length() < length) {
            return list;
        }

        long val = intOf(s.charAt(0));
        long base = 1;
        for (int i = 1; i < length; i++) {
            val = val * 10 + intOf(s.charAt(i));
            base *= 10;
        }

        Map<Long, Integer> map = new HashMap<>();
        map.put(val, 1);
        Integer count;
        for (int i = 0, j = length; j < s.length(); i++, j++) {
            val -= (intOf(s.charAt(i)) * base);
            val *= 10;
            val += intOf(s.charAt(j));

            count = map.get(val);
            if (count == null) {
                map.put(val, 1);
                continue;
            }

            if (count == 1) {
                list.add(stringOf(val));
                map.put(val, 2);
            }
        }

        return list;
    }

    private static int intOf (char c) {
        if (c == 'A') {
            return 1;
        } else if (c == 'C') {
            return 2;
        } else if (c == 'G') {
            return 3;
        } else { // 'T'
            return  4;
        }
    }

    private static String stringOf (long val) {
        StringBuilder sb = new StringBuilder();
        long i;
        while (val != 0) {
            i = val % 10;
            val = val / 10;
            if (i == 1) {
                sb.insert(0, 'A');
            } else if (i == 2) {
                sb.insert(0, 'C');
            } else if (i == 3) {
                sb.insert(0, 'G');
            } else {
                sb.insert(0, 'T');
            }
        }
        return sb.toString();
    }

}
