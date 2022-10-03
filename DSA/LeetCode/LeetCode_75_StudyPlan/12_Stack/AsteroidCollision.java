import java.util.Stack;
import java.util.Scanner;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i : asteroids) {
            if (i > 0) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(i)) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(i);
                } else if (i + stack.peek() == 0) {
                    stack.pop();
                }
            }
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] asteroids = new int[n];

        for (int i = 0; i < n; i++) {
            asteroids[i] = scr.nextInt();
        }

        int[] ans = asteroidCollision(asteroids);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        scr.close();
    }
}
