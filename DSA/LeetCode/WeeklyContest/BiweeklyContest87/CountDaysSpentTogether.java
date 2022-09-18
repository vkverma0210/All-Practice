import java.util.Scanner;

public class CountDaysSpentTogether {
    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arrive1 = calculateNoDays(arriveAlice);
        int leave1 = calculateNoDays(leaveAlice);
        int arrive2 = calculateNoDays(arriveBob);
        int leave2 = calculateNoDays(leaveBob);

        if (leave1 < arrive2 || leave2 < arrive1)
            return 0;

        return Math.abs(Math.max(arrive1, arrive2) - Math.min(leave1, leave2)) + 1;
    }

    private static int calculateNoDays(String str) {
        int[] NoOfDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int sum = 0;
        int month = Integer.valueOf(str.substring(0, 2));
        int day = Integer.valueOf(str.substring(3, 5));

        for (int i = 0; i < month - 1; i++) {
            sum += NoOfDays[i];
        }

        return day + sum;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String arriveAlice = scr.next();
        String leaveAlice = scr.next();
        String arriveBob = scr.next();
        String leaveBob = scr.next();

        System.out.println(countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));

        scr.close();
    }
}
