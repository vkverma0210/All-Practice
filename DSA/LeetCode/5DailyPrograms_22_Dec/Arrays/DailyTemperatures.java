import java.util.Stack;
import java.util.Scanner;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                ans[stack.peek()] = i - stack.pop();
            }

            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] temperatures = new int[n];
        for (int i = 0; i < n; i++) {
            temperatures[i] = scr.nextInt();
        }

        int[] ans = dailyTemperatures(temperatures);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }

        System.out.println();
        scr.close();
    }
}
