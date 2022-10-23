import java.util.Scanner;

public class DetermineIfTwoEventsHaveConflic {
    public static boolean haveConflict(String[] event1, String[] event2) {
        return (event1[0].compareTo(event2[1]) <= 0 && event2[0].compareTo(event1[1]) <= 0);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String[] event1 = new String[2];
        String[] event2 = new String[2];

        for (int i = 0; i < 2; i++) {
            event1[i] = scr.nextLine();
        }

        for (int i = 0; i < 2; i++) {
            event2[i] = scr.nextLine();
        }

        System.out.println(haveConflict(event1, event2));

        scr.close();
    }
}
