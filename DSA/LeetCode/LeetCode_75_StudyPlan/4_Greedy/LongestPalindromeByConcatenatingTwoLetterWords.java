import java.util.HashMap;
import java.util.Scanner;

public class LongestPalindromeByConcatenatingTwoLetterWords {
    public static int longestPalindrome(String[] words) {
        HashMap<String, Integer> hm = new HashMap<>();
        int unpaired = 0, ans = 0;

        for (String w : words) {
            if (!hm.containsKey(w)) {
                hm.put(w, 0);
            }

            if (w.charAt(0) == w.charAt(1)) {
                if (hm.get(w) > 0) {
                    unpaired--;
                    hm.put(w, hm.get(w) - 1);
                    ans += 4;
                } else {
                    hm.put(w, hm.get(w) + 1);
                    unpaired++;
                }
            } else {
                String rev = Character.toString(w.charAt(1)) + Character.toString(w.charAt(0));

                if (hm.containsKey(rev) && hm.get(rev) > 0) {
                    ans += 4;
                    hm.put(rev, hm.get(rev) - 1);
                } else {
                    hm.put(w, hm.get(w) + 1);
                }
            }
        }

        if (unpaired > 0)
            ans += 2;

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = scr.next();
        }

        System.out.println(longestPalindrome(words));
        scr.close();
    }
}
