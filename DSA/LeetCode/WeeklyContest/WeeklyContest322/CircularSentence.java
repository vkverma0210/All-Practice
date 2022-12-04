import java.util.Scanner;

public class CircularSentence {
    public static boolean isCircularSentence(String sentence) {
        String[] sen = sentence.split(" ");

        for (int i = 1; i < sen.length; i++) {
            char[] curr = sen[i - 1].toCharArray();
            char[] next = sen[i].toCharArray();
            if (curr[curr.length - 1] != next[0]) {
                return false;
            }
        }

        char[] curr = sen[sen.length - 1].toCharArray();
        char[] next = sen[0].toCharArray();

        if (curr[curr.length - 1] != next[0]) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String sentence = scr.nextLine();

        System.out.println(isCircularSentence(sentence));
        scr.close();
    }
}
