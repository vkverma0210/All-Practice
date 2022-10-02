import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0, n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            list.add(new int[] { curStart, curEnd });
            i++;
        }

        int[] m1 = newInterval;
        while (i < n && intervals[i][0] <= newInterval[1]) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            m1[0] = Math.min(m1[0], curStart);
            m1[1] = Math.max(m1[1], curEnd);
            i++;
        }

        list.add(m1);

        while (i < n) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];

            list.add(new int[] { curStart, curEnd });
            i++;
        }

        int[][] res = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            res[j][0] = list.get(j)[0];
            res[j][1] = list.get(j)[1];
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scr.nextInt();
            intervals[i][1] = scr.nextInt();
        }

        int[] newInterval = new int[2];
        for (int i = 0; i < 2; i++) {
            newInterval[i] = scr.nextInt();
        }

        int[][] ans = insert(intervals, newInterval);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }

        scr.close();
    }
}
