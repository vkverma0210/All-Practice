import java.util.Arrays;
import java.util.Scanner;

public class BagOfTokens {
    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int l = 0, r = tokens.length - 1, res = 0, points = 0;

        while (l <= r) {
            if (tokens[l] <= power) {
                power -= tokens[l++];
                res = Math.max(res, ++points);
            } else if (points > 0) {
                points--;
                power += tokens[r--];
            } else {
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] tokens = new int[n];

        for (int i = 0; i < n; i++) {
            tokens[i] = scr.nextInt();
        }

        int power = scr.nextInt();

        System.out.println(bagOfTokensScore(tokens, power));
        scr.close();
    }
}
