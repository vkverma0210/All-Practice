import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class SpellCheck {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            String str = scr.next();

            if (str.contains("T") && str.contains("i") && str.contains("m") && str.contains("u") && str.contains("r")
                    && str.length() == 5)
                System.out.println("YES");
            else
                System.out.println("NO");

            t--;
        }
        scr.close();
    }
}
