import java.util.Arrays;
import java.util.Scanner;

public class DetermineIfTwoStringsAreClose {
    public static boolean closeStrings(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            freq1[word1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < word2.length(); i++) {
            freq2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String word1 = scr.next();
        String word2 = scr.next();
        System.out.println(closeStrings(word1, word2));
        scr.close();
    }
}