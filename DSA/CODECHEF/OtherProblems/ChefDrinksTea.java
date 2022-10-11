import java.util.Scanner;

public class ChefDrinksTea {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int x = scr.nextInt();
            int y = scr.nextInt();
            int z = scr.nextInt();

            int count = y;
            int price = z;

            while (count < x) {
                count += y;
                price += z;
            }

            System.out.println(price);
            t--;
        }
        scr.close();
    }
}
