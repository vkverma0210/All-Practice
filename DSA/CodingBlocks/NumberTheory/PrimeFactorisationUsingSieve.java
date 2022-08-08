import java.util.Scanner;
import java.util.Vector;
import java.util.Iterator;

public class PrimeFactorisationUsingSieve {
    public static Vector<Integer> primeSieve(int[] p, int n) {
        p[0] = p[1] = 0;
        p[2] = 1;

        // Let us mark all Odd Number as Prime(Initialisation)
        for (int i = 3; i <= n; i += 2) {
            p[i] = 1;
        }

        // Sieve Login to mark non prime numbers as 0
        // 1. Optimisation: Iterate only over odd Numbers
        for (int i = 3; i <= n; i += 2) {
            if (p[i] == 1) {
                // Mark all the multiples of that number as not prime
                // 2. Optimisation take jump of 2i stating from i * i

                for (int j = i * i; j <= n; j += 2 * i) {
                    p[j] = 0;
                }
            }
        }

        Vector<Integer> primes = new Vector<>();
        primes.add(2);

        for (int i = 3; i <= n; i += 2) {
            if (p[i] == 1) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static Vector<Integer> factorize(int m, Vector<Integer> primes) {
        Vector<Integer> factors = new Vector<>();

        int i = 0;
        int p = primes.get(0);

        while (p * p <= m) {
            if (m % p == 0) {
                factors.add(p);
                while (m % p == 0) {
                    m = m / p;
                }
            }

            // go ot next step
            i++;
            p = primes.get(i);
        }

        if (m != 1) {
            factors.add(m);
        }

        return factors;
    }

    public static void main(String[] args) {
        int N = 1000000;
        int[] p = new int[N];

        Vector<Integer> primes = primeSieve(p, 10000);

        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int no = scr.nextInt();

            Vector<Integer> factors = factorize(no, primes);

            Iterator value = factors.iterator();
            while (value.hasNext()) {
                System.out.println(value.next());
            }

            // System.out.println(factors);

            t--;
        }
    }
}
