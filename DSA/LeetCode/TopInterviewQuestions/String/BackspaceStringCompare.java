import java.util.Scanner;
import java.util.Stack;

public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> t1 = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != '#') {
                s1.push(c);
            } else if (!s1.isEmpty()) {
                s1.pop();
            }
        }

        for (char c : t.toCharArray()) {
            if (c != '#') {
                t1.push(c);
            } else if (!t1.isEmpty()) {
                t1.pop();
            }
        }

        return s1.equals(t1);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();
        String t = scr.next();
        System.out.println(backspaceCompare(s, t));

        scr.close();
    }
}
