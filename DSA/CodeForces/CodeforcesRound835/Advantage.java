import java.util.Arrays;
import java.util.Scanner;

public class Advantage {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            long[] arr = new long[n];
            long[] temp = new long[n];

            long maxi = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = scr.nextLong();
                temp[i] = arr[i];

                if (arr[i] > maxi) {
                    maxi = arr[i];
                }
            }

            Arrays.sort(temp);

            for (int i = 0; i < n; i++) {
                if (arr[i] == maxi) {
                    System.out.print(arr[i] - temp[n - 2] + " ");
                } else {
                    System.out.print(arr[i] - maxi + " ");
                }
            }

            System.out.println();
            t--;
        }

        scr.close();
    }
}
