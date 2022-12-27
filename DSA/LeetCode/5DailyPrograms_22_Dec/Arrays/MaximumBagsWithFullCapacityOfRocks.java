import java.util.Arrays;
import java.util.Scanner;

public class MaximumBagsWithFullCapacityOfRocks {
    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;

        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(diff);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (diff[i] == 0) {
                ans++;
            } else {
                if (additionalRocks >= diff[i]) {
                    additionalRocks = additionalRocks - diff[i];
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] capacity = new int[n];
        for (int i = 0; i < n; i++) {
            capacity[i] = scr.nextInt();
        }

        int[] rocks = new int[n];
        for (int i = 0; i < n; i++) {
            rocks[i] = scr.nextInt();
        }

        int additionalRocks = scr.nextInt();

        System.out.println(maximumBags(capacity, rocks, additionalRocks));
        scr.close();
    }
}