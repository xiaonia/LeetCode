package leetcode.problems;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */
@Deprecated
public class LeetCode_0125_ValidPalindrome {

    public boolean isPalindrome(String s) {
        return run(s);
    }

    public static boolean run(String s) {
        if (s == null) {
            return false;
        }

        s = s.toLowerCase();
        int indexLeft = 0;
        int indexRight = s.length() - 1;
        char charLeft = 0;
        char charRight = 0;

        while (indexLeft <= indexRight) {
            charLeft = s.charAt(indexLeft);
            if (!Character.isLetter(charLeft) && !Character.isDigit(charLeft)) {
                indexLeft ++;
                continue;
            }

            charRight = s.charAt(indexRight);
            if (!Character.isLetter(charRight) && !Character.isDigit(charRight)) {
                indexRight --;
                continue;
            }

            if (charLeft != charRight) {
                return false;
            }

            indexLeft ++;
            indexRight --;
        }
        return true;
    }



}
