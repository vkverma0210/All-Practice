import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EndSorted {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();

            List<Integer> arr = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                int x = scr.nextInt();
                arr.add(x);
            }

            for (int i = 0; i < n; i++) {
                System.out.println(arr.get(i));
            }

            int count = 0;
            for (int i = 0; i < n - 1; i++) {
                if (arr.get(i) > arr.get(i + 1)) {
                    count++;
                    Collections.swap(arr, i, i + 1);
                }
            }

            System.out.println();

            for (int i = 0; i < n; i++) {
                System.out.println(arr.get(i));
            }

            System.out.println(count);

            t--;
        }
        scr.close();
    }
}
