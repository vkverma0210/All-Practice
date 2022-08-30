import java.util.Scanner;
import java.util.Stack;

public class RemovingStarsFromaString {
    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '*')
                st.pop();
            else
                st.push(c);
        }

        while (!st.isEmpty())
            sb.append(st.pop());

        return sb.reverse().toString();
    }

    public static String removeStars1(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '*')
                sb.setLength(sb.length() - 1);
            else
                sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String str = scr.next();

        System.out.println(removeStars(str));

        scr.close();
    }
}
