import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PolycarpWritesStringFromMemory {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int t = scr.nextInt();

        while (t != 0) {
            String str = scr.next();

            int count = 0;

            Set<Character> s = new HashSet<>();

            for (int i = 0; i < str.length(); i++) {
                s.add(str.charAt(i));

                if (s.size() == 4) {
                    count++;
                    s.clear();
                    s.add(str.charAt(i));
                }
            }

            if (!s.isEmpty()) {
                count++;
            }

            System.out.println(count);

            t--;
        }
        scr.close();
    }
}
