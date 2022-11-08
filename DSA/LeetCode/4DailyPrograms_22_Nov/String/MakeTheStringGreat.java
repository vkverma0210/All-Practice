import java.util.Scanner;
import java.util.Stack;

public class MakeTheStringGreat {
    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - ch) == ('a' - 'A')) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        char[] ch = new char[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            ch[i--] = stack.pop();
        }

        return new String(ch);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String s = scr.next();
        System.out.println(makeGood(s));

        scr.close();
    }
}
