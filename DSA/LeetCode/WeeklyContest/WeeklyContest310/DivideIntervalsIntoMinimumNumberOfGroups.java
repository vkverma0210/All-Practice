import java.util.Arrays;
import java.util.Scanner;

public class DivideIntervalsIntoMinimumNumberOfGroups {
    public static int minGroups(int[][] intervals) {
        int n = intervals.length;

        int[] begins = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            begins[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(begins);
        Arrays.sort(end);

        int j = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (begins[i] <= end[j])
                res++;
            else
                j++;
        }

        return res;
    }

    public static int minGroups_2(int[][] intervals) {
        int maxElement = 0;

        for (int i[] : intervals) {
            maxElement = Math.max(maxElement, i[0]);
            maxElement = Math.max(maxElement, i[1]);
        }

        long[] prefixSum = new long[maxElement + 2];

        for (int i[] : intervals) {
            prefixSum[i[0]] += 1;
            prefixSum[i[1] + 1] -= 1;
        }

        long ans = 0;

        for (int i = 1; i <= maxElement + 1; i++) {
            prefixSum[i] += prefixSum[i - 1];
            ans = Math.max(ans, prefixSum[i]);
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scr.nextInt();
            intervals[i][1] = scr.nextInt();
        }

        System.out.println(minGroups(intervals));
        System.out.println(minGroups_2(intervals));

        scr.close();
    }
}
