import java.util.Scanner;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int last1 = stack.pop();
                int last2 = stack.pop();
                stack.push(last1 + last2);
            } else if (token.equals("-")) {
                int last1 = -stack.pop();
                int last2 = stack.pop();
                stack.push(last1 + last2);
            } else if (token.equals("*")) {
                int last1 = stack.pop();
                int last2 = stack.pop();
                stack.push(last1 * last2);
            } else if (token.equals("/")) {
                double last1 = 1D / stack.pop();
                int last2 = stack.pop();
                stack.push((int) (last1 * last2));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        String[] tokens = new String[n];
        for (int i = 0; i < n; i++) {
            tokens[i] = scr.next();
        }

        System.out.println(evalRPN(tokens));
        scr.close();
    }
}