import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0, left = 0, right = 0;
        Set<Character> window = new HashSet<>();

        while (right < s.length()) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left++));
            }

            window.add(s.charAt(right++));
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();

        System.out.println(lengthOfLongestSubstring(s));
        scr.close();
    }
}
