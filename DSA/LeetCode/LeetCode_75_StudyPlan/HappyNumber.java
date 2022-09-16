import java.util.HashSet;
import java.util.Scanner;

public class HappyNumber {
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);

        while (n != 1) {
            int res = 0;
            while (n != 0) {
                res += Math.pow(n % 10, 2);
                n /= 10;
            }

            if (set.contains(res)) {
                return false;
            }

            set.add(res);
            n = res;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        System.out.println(isHappy(n));

        scr.close();
    }
}
