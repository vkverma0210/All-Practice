import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class MaximumNumberOfRobotsWithinBudget {
    public static int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        long sum = 0;

        int i = 0, n = chargeTimes.length;
        Deque<Integer> d = new LinkedList<>();

        for (int j = 0; j < n; j++) {
            sum += runningCosts[j];

            while (!d.isEmpty() && chargeTimes[d.peekLast()] <= chargeTimes[j]) {
                d.pollLast();
            }

            d.addLast(j);

            if (chargeTimes[d.getFirst()] + (j - i + 1) * sum > budget) {
                if (d.getFirst() == i) {
                    d.pollFirst();
                }
                sum -= runningCosts[i++];
            }
        }

        return n - i;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] chargeTimes = new int[n];
        for (int i = 0; i < n; i++) {
            chargeTimes[i] = scr.nextInt();
        }

        int[] runningCosts = new int[n];
        for (int i = 0; i < n; i++) {
            runningCosts[i] = scr.nextInt();
        }

        long budget = scr.nextLong();

        System.out.println(maximumRobots(chargeTimes, runningCosts, budget));

        scr.close();
    }
}
