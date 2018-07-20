package problems;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 */
//TODO
public class LeetCode_0091_DecodeWays {

    public static int numDecodings(String s) {
        if(s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int c1 = 1; //前(i)个char的解码方式
        int c2 = 1; //前(i - 1)个char的解码方式
        for(int i = 1 ; i < s.length();i++){
            if(s.charAt(i) == '0') { //
                c1 = 0;
            }

            if((s.charAt(i-1) == '1') //10 -> 19  (i-1, i) is valid
                    || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')){ //20 -> 26
                c1 = c1 + c2;
                c2 = c1 - c2;
            }else{ //(i-1, i) is invalid
                c2 = c1;
            }
        }

        return c1;
    }

    /*public static int numDecodings(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }

        int[] tmp = new int[s.length() + 1];

        try {
            return countWays(tmp, s, 0, 1, 26);
        } catch (IllegalStateException ise) {
            return 0;
        }
    }*/

    private static int countWays(int[] tmp, String input, int index, int min, int max) throws IllegalStateException {
        if (index >= input.length()) {
            return 1;
        }

        if (tmp[index] > 0) {
            return tmp[index];
        }

        int vofc1 = Integer.valueOf(input.substring(index, index + 1));
        if (vofc1 < min) {
            throw new IllegalStateException("Invalid input!");
        }
        if (index == input.length() - 1) {
            return 1;
        }

        int vofc2 = Integer.valueOf(input.substring(index + 1, index + 2));
        int vofc12 = Integer.valueOf(input.substring(index, index + 2));
        if (vofc2 < min && (vofc12 > max || vofc12 < min)) {
            throw new IllegalStateException("Invalid input!");
        }

        if (index == input.length() - 2) {
            if (vofc2 < min || vofc12 > max) {
                return 1;
            }
            return 2;
        }

        int vofc3 = Integer.valueOf(input.substring(index + 2, index + 3));
        int vofc23 = Integer.valueOf(input.substring(index + 1, index + 3));
        if (vofc3 < min && (vofc23 > max || vofc23 < min)) {
            throw new IllegalStateException("Invalid input!");
        }

        int count = 0;
        if (vofc3 < min)  { //1,23
            count += countWays(tmp, input, index + 3, min, max);
        } else if (vofc2 < min) { //12,3
            count += countWays(tmp, input, index + 2, min, max);
        } else if (vofc23 > max) {//1,2,3 || 12,3
            if (vofc12 > max) {
                count += countWays(tmp, input, index + 2, min, max);
            } else {
                count += 2 * countWays(tmp, input, index + 2, min, max);
            }
        } else if (vofc12 > max) {//1,23 || 1,2,3
            count += countWays(tmp, input, index + 3, min, max);
            count += countWays(tmp, input, index + 2, min, max);
        } else { //1, 2, 3 || 12,3 || 1,23
            count += 2 * countWays(tmp, input, index + 2, min, max);
            count += countWays(tmp, input, index + 3, min, max);
        }
        tmp[index] = count;
        return count;
    }

}
