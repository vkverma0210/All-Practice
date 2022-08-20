import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumNumberofRefuelingStops {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int xCurrent = startFuel;
        int noOfStopsNeeded = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        for (int[] station : stations) {
            int nextStationX = station[0];
            int fuelAtStation = station[1];

            while (xCurrent < nextStationX) {
                if (pq.isEmpty()) {
                    return -1;
                }

                int maxFuel = pq.poll();
                xCurrent = xCurrent + maxFuel;
                noOfStopsNeeded++;
            }

            pq.offer(fuelAtStation);
        }

        while (xCurrent < target) {
            if (pq.isEmpty()) {
                return -1;
            }

            int maxFuel = pq.poll();
            xCurrent = xCurrent + maxFuel;
            noOfStopsNeeded++;
        }

        return noOfStopsNeeded;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[][] stations = new int[n][2];

        for (int i = 0; i < n; i++) {
            stations[i][0] = scr.nextInt();
            stations[i][1] = scr.nextInt();
        }

        int target = scr.nextInt();
        int startFuel = scr.nextInt();

        System.out.println(minRefuelStops(target, startFuel, stations));
        scr.close();
    }
}
