import java.util.Arrays;
import java.util.Scanner;

public class MeetingRoomsIII {
    public static int mostBooked(int n, int[][] meetings) {
        long[] rooms = new long[n]; // stores end time
        int[] counters = new int[n]; // No of times room used

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        for (int[] pair : meetings) {
            int idx = 0;
            long min = rooms[0];

            for (int i = 0; i < n; i++) {
                if (rooms[i] <= pair[0]) {
                    // assign the first available room to next meeting
                    rooms[i] = pair[1];
                    counters[i]++;
                    idx = -1;
                    break;
                }

                // if no available room, record the earliest ending room
                if (rooms[i] < min) {
                    min = rooms[i];
                    idx = i;
                }
            }

            if (idx != -1) {
                rooms[idx] += pair[1] - pair[0];
                counters[idx]++;
            }
        }

        int maxa = 0, idx = 0;

        for (int i = 0; i < n; i++) {
            if (counters[i] > maxa) {
                maxa = counters[i];
                idx = i;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int m = scr.nextInt();

        int[][] meetings = new int[m][2];

        for (int i = 0; i < m; i++) {
            meetings[i][0] = scr.nextInt();
            meetings[i][1] = scr.nextInt();
        }

        System.out.println(mostBooked(n, meetings));

        scr.close();
    }
}
