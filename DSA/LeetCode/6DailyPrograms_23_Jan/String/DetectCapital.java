import java.util.Scanner;

public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        if (word.length() < 2) {
            return true;
        }

        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            for (int i = 2; i < word.length(); i++) {
                if (Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String word = scr.next();
        System.out.println(detectCapitalUse(word));
        scr.close();
    }
}
