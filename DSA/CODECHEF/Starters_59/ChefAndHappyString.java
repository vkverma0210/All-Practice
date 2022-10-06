import java.util.Scanner;
import java.util.HashSet;

public class ChefAndHappyString {
    public static String solve(String str) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int count = 0;
        for (Character ch : str.toCharArray()) {
            if (set.contains(ch)) {
                count++;
            } else {
                count = 0;
            }

            if (count > 2) {
                return "HAPPY";
            }
        }

        return "Sad";
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            String str = scr.next();

            System.out.println(solve(str));
            t--;
        }

        scr.close();
    }
}
