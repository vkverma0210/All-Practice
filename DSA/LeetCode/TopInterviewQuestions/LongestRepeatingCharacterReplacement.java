import java.util.Scanner;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;

        for (int end = 0; end < n; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();
        int k = scr.nextInt();

        System.out.println(characterReplacement(s, k));

        scr.close();
    }
}
