import java.util.Scanner;

public class ReverseWordsinaStringIII {
    public static String reverseWords(String s) {
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            str[i] = new StringBuilder(str[i]).reverse().toString();
        }

        StringBuilder result = new StringBuilder();
        for (String st : str) {
            result.append(st + " ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String str = scr.nextLine();

        System.out.println(reverseWords(str));

        scr.close();
    }
}
