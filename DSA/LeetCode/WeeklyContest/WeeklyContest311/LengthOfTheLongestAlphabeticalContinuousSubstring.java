import java.util.Scanner;

public class LengthOfTheLongestAlphabeticalContinuousSubstring {
    public static int longestContinuousSubstring(String s) {
        int ans = 1;

        for (int i = 1; i < s.length(); i++) {
            int currentCount = 1;

            while (i < s.length() && s.charAt(i - 1) + 1 == s.charAt(i)) {
                currentCount++;
                i++;
            }

            ans = Math.max(ans, currentCount);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();

        System.out.println(longestContinuousSubstring(s));

        scr.close();
    }
}
