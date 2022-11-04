import java.util.Scanner;

public class ReverseVowelsOfAString {
    public static String reverseVowels(String s) {
        int start = 0, end = s.length() - 1;
        char[] str = s.toCharArray();
        while (start < end) {
            while (start < end && !isVowel(str[start])) {
                start++;
            }

            while (start < end && !isVowel(str[end])) {
                end--;
            }

            if (start < end) {
                char temp = str[start];
                str[start++] = str[end];
                str[end--] = temp;
            }
        }

        return new String(str);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U';
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();

        System.out.println(reverseVowels(s));

        scr.close();
    }
}
