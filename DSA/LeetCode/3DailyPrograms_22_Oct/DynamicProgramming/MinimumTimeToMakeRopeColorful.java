import java.util.Scanner;

public class MinimumTimeToMakeRopeColorful {
    public static int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int result = 0;

        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                result = result + Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String colors = scr.next();
        int n = scr.nextInt();
        int[] neededTime = new int[n];

        for (int i = 0; i < n; i++) {
            neededTime[i] = scr.nextInt();
        }

        System.out.println(minCost(colors, neededTime));

        scr.close();
    }
}