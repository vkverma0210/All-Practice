import java.util.Scanner;
import java.util.Set;

public class UniqueNumberII {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] arr = new int[n];

        int no;
        int xor = 0;

        for (int i = 0; i < n; i++) {
            no = scr.nextInt();
            arr[i] = no;
            xor = xor ^ no;
        }

        int temp = xor;
        int pos = 0;

        while ((temp & 1) == 0) {
            pos = pos + 1;
            temp = temp >> 1;
        }

        int mask = (1 << pos);

        int a = 0;
        int b = 0;

        for (int i = 0; i < n; i++) {
            if ((arr[i] & mask) > 0) {
                a = a ^ arr[i];
            }
        }

        b = xor ^ a;

        System.out.println(Math.min(a, b));
        System.out.println(Math.max(a, b));

        scr.close();
    }
}
