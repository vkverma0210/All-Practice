import java.util.Scanner;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas < totalCost) {
            return -1;
        }

        int gasRemains = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            gasRemains = gasRemains + (gas[i] - cost[i]);

            if (gasRemains < 0) {
                start = i + 1;
                gasRemains = 0;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] gas = new int[n];
        for (int i = 0; i < n; i++) {
            gas[i] = scr.nextInt();
        }

        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = scr.nextInt();
        }

        System.out.println(canCompleteCircuit(gas, cost));
        scr.close();
    }
}