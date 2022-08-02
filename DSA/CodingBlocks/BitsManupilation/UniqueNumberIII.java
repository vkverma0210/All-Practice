import java.util.Scanner;

public class UniqueNumberIII {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] count = new int[64];

        int no;

        for (int i = 0; i < n; i++) {
            no = scr.nextInt();
            int j = 0;
            while (no > 0) {
                int last_bit = (no & 1);
                count[j] += last_bit;
                j++;
                no = no >> 1;
            }
        }

        int pow = 1;
        int ans = 0;

        for (int i = 0; i < 64; i++) {
            count[i] = count[i] % 3;
            ans += count[i] * pow;
            pow = pow << 1;
        }

        System.out.println(ans);

        scr.close();
    }
}
