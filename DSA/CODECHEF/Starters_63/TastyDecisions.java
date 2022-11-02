import java.util.Scanner;

public class TastyDecisions {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int x = scr.nextInt();
            int y = scr.nextInt();

            int chocolate = x * 2;
            int candy = y * 5;

            if (chocolate > candy) {
                System.out.println("Chocolate");
            } else if (chocolate < candy) {
                System.out.println("Candy");
            } else {
                System.out.println("Either");
            }

            t--;
        }

        scr.close();
    }

}