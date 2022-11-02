import java.util.Scanner;

public class MakeLength1 {
    public static String solve(int n, String str) {
        int count = 0;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if (n == 1) {
                return "YES";
            }

            if (str.charAt(i) == '0') {
                if (count % 2 == 1) {
                    return "NO";
                }
                count = 0;
            } else {
                count += 2;
                count -= 1;
            }
        }

        if (count % 2 == 1) {
            return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            String str = scr.next();

            System.out.println(solve(n, str));
            t--;
        }

        scr.close();
    }
}
