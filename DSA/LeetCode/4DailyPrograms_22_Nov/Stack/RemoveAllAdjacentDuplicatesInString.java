import java.util.Scanner;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
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

        System.out.println(removeDuplicates(s));
        scr.close();
    }
}
