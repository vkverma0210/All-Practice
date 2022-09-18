import java.util.Arrays;
import java.util.Scanner;

public class MaximumMatchingOfPlayersWithTrainers {
    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int ans = 0;
        int i = 0, j = 0;
        int n = players.length, m = trainers.length;

        while (i < n && j < m) {
            if (players[i] <= trainers[j]) {
                ans++;
                i++;
                j++;
            } else if (players[i] > trainers[j]) {
                j++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[] players = new int[n];

        for (int i = 0; i < n; i++) {
            players[i] = scr.nextInt();
        }

        int m = scr.nextInt();
        int[] trainers = new int[m];

        for (int i = 0; i < m; i++) {
            trainers[i] = scr.nextInt();
        }

        System.out.println(matchPlayersAndTrainers(players, trainers));

        scr.close();
    }
}
