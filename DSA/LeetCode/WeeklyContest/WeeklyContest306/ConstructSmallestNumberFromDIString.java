import java.util.Scanner;

public class ConstructSmallestNumberFromDIString {
    public static String smallestNumber(String pattern) {
        StringBuilder res = new StringBuilder(), stack = new StringBuilder();

        for (int i = 0; i <= pattern.length(); i++) {
            stack.append((char) ('1' + i));

            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                res.append(stack.reverse());
                stack = new StringBuilder();
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String str = scr.next();

        System.out.println(smallestNumber(str));

        scr.close();
    }
}
