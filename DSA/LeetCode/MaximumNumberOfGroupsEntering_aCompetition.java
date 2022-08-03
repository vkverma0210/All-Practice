import java.util.Scanner;

public class MaximumNumberOfGroupsEntering_aCompetition {
    public static int maximumGroups(int[] grades) {
        int n = grades.length;
        int k = 0, total = 0;

        while (total + k + 1 <= n) {
            k++;
            total += k;
        }

        return k;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        int[] grades = new int[n];

        for (int i = 0; i < n; i++) {
            grades[i] = scr.nextInt();
        }

        System.out.println(maximumGroups(grades));

        scr.close();
    }
}
