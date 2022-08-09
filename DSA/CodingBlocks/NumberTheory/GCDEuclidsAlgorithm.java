import java.util.Scanner;

public class GCDEuclidsAlgorithm {
    public static int gcd(int n1, int n2) {
        return n2 == 0 ? n1 : gcd(n2, n1 % n2);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n1 = scr.nextInt();
        int n2 = scr.nextInt();

        int gcdAns = gcd(n1, n2);
        System.out.println("GCD = " + gcdAns);
        int lcmAns = (n1 * n2) / gcdAns;
        System.out.println("LCM = " + lcmAns);

        scr.close();
    }
}
