import java.util.Scanner;

public class Squats {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();

            System.out.println(n * 15);
            t--;
        }

        scr.close();
    }
}