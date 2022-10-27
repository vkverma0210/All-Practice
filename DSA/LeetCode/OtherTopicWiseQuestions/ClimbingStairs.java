import java.util.Scanner;

public record ClimbingStairs() {
    public static int climbStairs(int n) {
        if (n <= 2)
            return n;

        int previous = 1;
        int current = 2;

        for (int i = 3; i <= n; i++) {
            int temp = current;
            current += previous;
            previous = temp;
        }

        return current;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int ans = climbStairs(n);

        System.out.println(ans);

        scr.close();
    }
}
