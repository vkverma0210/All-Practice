import java.util.Scanner;
import java.util.Stack;

public class BasicCalculatorII {
    public static int calculate(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }

            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }

                if (sign == '+') {
                    stack.push(num);
                }

                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }

                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = s.charAt(i);
                num = 0;
            }
        }

        int res = 0;
        for (int i : stack) {
            res += i;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.nextLine();

        System.out.println(calculate(s));

        scr.close();
    }
}
