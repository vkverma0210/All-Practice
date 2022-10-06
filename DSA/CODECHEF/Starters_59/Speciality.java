import java.util.Scanner;

public class Speciality {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int x = scr.nextInt();
            int y = scr.nextInt();
            int z = scr.nextInt();
            if (x > y && x > z) {
                System.out.println("Setter");
            } else if (y > x && y > z) {
                System.out.println("Tester");
            } else {
                System.out.println("Editorialist");
            }

            t--;
        }

        scr.close();
    }
}
