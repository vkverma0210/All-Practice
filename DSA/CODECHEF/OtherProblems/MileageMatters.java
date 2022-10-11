import java.util.Scanner;

public class MileageMatters {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            int x = scr.nextInt();
            int y = scr.nextInt();
            int a = scr.nextInt();
            int b = scr.nextInt();

            float petrol = ((float) x / a);
            System.out.println(petrol);
            float diesel = ((float) y / b);
            System.out.println(diesel);

            if (petrol < diesel) {
                System.out.println("PETROL");
            } else if (petrol > diesel) {
                System.out.println("DIESEL");
            } else {
                System.out.println("ANY");
            }

            t--;
        }
        scr.close();
    }
}
