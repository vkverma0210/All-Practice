import java.util.Scanner;

public class PackingBooks {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int x = scr.nextInt();
            int y = scr.nextInt();
            int z = scr.nextInt();

            int quo = y / z;
            int rem = y % z;

            if (rem == 0) {
                System.out.println(x * quo);
            } else {
                System.out.println(x * quo + x);
            }

            t--;
        }

        scr.close();
    }
}
