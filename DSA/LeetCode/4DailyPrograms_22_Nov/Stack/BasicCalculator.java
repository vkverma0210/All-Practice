import java.util.Scanner;
import java.util.Stack;

public class BasicCalculator {
    public static int calculate(String s) {
        int sum = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }

                i--;
                val = val * sign;
                sign = 1;
                sum += val;
            } else if (ch == '(') {
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            } else if (ch == ')') {
                sum *= stack.pop();
                sum += stack.pop();
            } else if (ch == '-') {
                sign *= -1;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.nextLine();
        System.out.println(calculate(s));
        scr.close();
    }

}