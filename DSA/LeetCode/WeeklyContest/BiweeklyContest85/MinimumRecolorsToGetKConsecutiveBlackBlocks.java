import java.util.Scanner;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public static int minimumRecolors(String blocks, int k) {
        int minSteps = Integer.MAX_VALUE;
        int lo = -1, white = 0;
        for (int hi = 0; hi < blocks.length(); hi++) {
            white += blocks.charAt(hi) == 'W' ? 1 : 0;

            if (hi - lo >= k) {
                minSteps = Math.min(white, minSteps);

                white -= blocks.charAt(++lo) == 'W' ? 1 : 0;
            }
        }

        return minSteps;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String blocks = scr.next();

        int k = scr.nextInt();

        System.out.println(minimumRecolors(blocks, k));
        scr.close();
    }
}