import java.util.Scanner;

public class CheckIfTwoStringArraysAreEquivalent {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String str1 = String.join("", word1);
        String str2 = String.join("", word2);
        return str1.equals(str2);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        String[] word1 = new String[n];
        for (int i = 0; i < n; i++) {
            word1[i] = scr.next();
        }

        int m = scr.nextInt();
        String[] word2 = new String[m];
        for (int i = 0; i < m; i++) {
            word2[i] = scr.next();
        }

        System.out.println(arrayStringsAreEqual(word1, word2));

        scr.close();
    }
}
