import java.util.Scanner;

public class AirConditionerTemperature {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int t = scr.nextInt();

        while (t != 0) {

            int a = scr.nextInt();
            int b = scr.nextInt();
            int c = scr.nextInt();
            if (a <= b && c <= b) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

            t--;
        }

        scr.close();
    }
}
