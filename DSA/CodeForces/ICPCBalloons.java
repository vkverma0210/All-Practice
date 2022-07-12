import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ICPCBalloons {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();

            String str = scr.next();

            Set<Character> hs = new HashSet<>();

            int ans = 0;

            for (int i = 0; i < n; i++) {
                if (!hs.contains(str.charAt(i))) {
                    hs.add(str.charAt(i));
                    ans += 2;
                } else {
                    ans++;
                }
            }

            System.out.println(ans);

            t--;
        }

        scr.close();
    }
}
