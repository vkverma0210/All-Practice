import java.util.Stack;
import java.util.Scanner;
import java.lang.StringBuilder;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c); // push everything before ]
            } else {
                // Step 1: if we find a closing ] then retrieve the string it encapsulates
                StringBuilder sb = new StringBuilder();
                while (Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }

                String sub = sb.toString(); // this is the string contained in []
                stack.pop(); // Discard the [

                // Step 2: After that get the number of times it should repeat from stack ->
                // number before bracket[
                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }

                int count = Integer.valueOf(sb.toString()); // this is number

                // Step 3: repeat the string within the [] count number of times it back into
                // stack

                while (count > 0) {
                    for (char ch : sub.toCharArray()) {
                        stack.push(ch);
                    }

                    count--;
                }
            }
        }

        // Final fetching and returning the value in stack
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();
        System.out.println(decodeString(s));

        scr.close();
    }
}
