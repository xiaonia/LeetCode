package problems;

import java.util.ArrayList;
import java.util.List;

/**
 Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 Example:
 Input: "25525511135"
 Output: ["255.255.11.135", "255.255.111.35"]
 */
@Deprecated
public class LeetCode_0093_RestoreIPAddresses {

    public static List<String> restoreIpAddresses(String s) {
        return restoreIpAddresses(4, s, 0);
    }

    public static List<String> restoreIpAddresses(int segment, String s, int index) {
        List<String> result = new ArrayList<>();
        if ((s.length() - index > segment * 3) || (s.length() - index < segment)) {
            return result;
        }

        int value = 0;
        if (segment == 1) {
            if (s.charAt(index) == '0' && index != s.length() - 1) {
                return result;
            }
            value = Integer.valueOf(s.substring(index));
            if (value <= 255) {
                result.add(value + "");
            }
            return result;
        }

        for (int i = index + 1; i <= s.length() && i <= index + 3; i++) {
            value = Integer.valueOf(s.substring(index, i));
            if (value <= 255) {
                List<String> list = restoreIpAddresses(segment - 1, s, i);
                for (String item : list) {
                    result.add(value + "." + item);
                }
                if (value == 0) {
                    break;
                }
            }
        }

        return result;
    }

}
