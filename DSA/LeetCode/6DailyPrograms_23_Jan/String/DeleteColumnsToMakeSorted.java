import java.util.Scanner;

public class DeleteColumnsToMakeSorted {
    public static int minDeletionSize(String[] strs) {
        int deleteCount = 0;
        int n = strs.length;
        int m = strs[0].length();

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    deleteCount++;
                    break;
                }
            }
        }

        return deleteCount;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        String[] strs = new String[n];

        for (int i = 0; i < n; i++) {
            strs[i] = scr.next();
        }

        System.out.println(minDeletionSize(strs));
        scr.close();
    }
}