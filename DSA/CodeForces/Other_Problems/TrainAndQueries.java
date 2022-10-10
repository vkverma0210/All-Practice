import java.util.HashMap;
import java.util.Scanner;

public class TrainAndQueries {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int k = scr.nextInt();

            HashMap<Integer, Integer> first = new HashMap<>();
            HashMap<Integer, Integer> last = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int station = scr.nextInt();

                if (!first.containsKey(station)) {
                    first.put(station, i);
                }

                last.put(station, i);
            }

            for (int i = 0; i < k; i++) {
                int l = scr.nextInt();
                int r = scr.nextInt();

                if (!first.containsKey(l) || !last.containsKey(r)) {
                    System.out.println("NO");
                } else if (first.get(l) > last.get(r)) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }

            t--;
        }

        scr.close();
    }
}
