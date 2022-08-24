import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Bridge {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n1 = scr.nextInt();
        int[] arr1 = new int[n1];

        int n2 = scr.nextInt();
        int[] arr2 = new int[n2];

        SortedSet<Integer> ts = new TreeSet<>();

        for (int i = 0; i < n1; i++) {
            arr1[i] = scr.nextInt();
            ts.add(arr1[i]);
        }

        for (int i = 0; i < n2; i++) {
            arr2[i] = scr.nextInt();
            ts.add(arr2[i]);
        }

        System.out.println(ts);

        int n = ts.size();
        int temp[] = new int[n];

        int i = 0;
        for (Integer x : ts) {
            temp[i++] = x;
        }

        if (n % 2 == 0) {
            float ans = ((float) temp[n / 2 - 1] + temp[n / 2]) / 2;
            System.out.println(String.format("%.2f", ans));
        } else {
            System.out.println((Integer) temp[n / 2]);
        }

        scr.close();
    }
}
