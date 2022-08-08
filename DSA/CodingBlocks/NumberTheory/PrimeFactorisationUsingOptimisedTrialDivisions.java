import java.util.Scanner;
import java.util.Vector;

public class PrimeFactorisationUsingOptimisedTrialDivisions {
    public static void primeFactors(int n) {
        Vector<Vector<Integer>> factors = new Vector<Vector<Integer>>();

        int count;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                count = 0;
                while (n % i == 0) {
                    count++;
                    n = n / i;
                }

                Vector<Integer> temp = new Vector<>();
                temp.add(i);
                temp.add(count);
                factors.add(temp);
            }
        }

        if (n != 1) {
            // whatever is left is a prime number in itself
            Vector<Integer> temp = new Vector<>();
            temp.add(n);
            temp.add(1);
            factors.add(temp);
        }

        // print the factors
        System.out.println(factors);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();

        primeFactors(n);
    }
}
