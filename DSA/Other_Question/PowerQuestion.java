import java.util.Arrays;
import java.util.Scanner;

public class PowerQuestion {
    public static int calculate(int a, int[] b) {
        Arrays.sort(b);

        int max_so_far = b[0];
        int curr_max = 0;

        for (int i = 0; i < a; i++) {
            curr_max = b[i] * (a - i);
            max_so_far = Integer.max(max_so_far, curr_max);
        }

        return max_so_far;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int a = scr.nextInt();

        int[] b = new int[a];

        for (int i = 0; i < a; i++) {
            b[i] = scr.nextInt();
        }

        System.out.println(calculate(a, b));

        scr.close();
    }
}
