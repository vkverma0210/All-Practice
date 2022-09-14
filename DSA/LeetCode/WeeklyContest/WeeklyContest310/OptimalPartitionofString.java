import java.util.HashSet;
import java.util.Scanner;

public class OptimalPartitionofString {
    public static int partitionString(String s) {
        HashSet<Character> hs = new HashSet<>();
        int ans = 1;

        for (char c : s.toCharArray()) {
            if (hs.contains(c)) {
                hs.clear();
                ans++;
            }

            hs.add(c);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String str = scr.next();

        System.out.println(partitionString(str));

        scr.close();
    }
}
