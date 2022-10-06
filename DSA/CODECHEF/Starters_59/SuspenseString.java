import java.util.Scanner;
import java.lang.StringBuilder;

public class SuspenseString {
    public static String solve(String str, int n) {
        int i = 0;
        int j = n - 1;
        boolean flag = true;
        StringBuilder res = new StringBuilder();

        while (i <= j) {
            if (flag == true) {
                if (str.charAt(i) == '1') {
                    res = res.append(str.charAt(i));
                } else {
                    res = res.insert(0, str.charAt(i));
                }
                i++;
                flag = false;
            } else {
                {
                    if (str.charAt(j) == '0') {
                        res = res.append(str.charAt(j));
                    } else {
                        res = res.insert(0, str.charAt(j));
                    }
                    j--;
                    flag = true;
                }
            }
        }

        String ans = res.toString();
        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            String str = scr.next();

            System.out.println(solve(str, n));
            t--;
        }

        scr.close();
    }
}
