import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmallestValueAfterReplacingWithSumOfPrimeFactors {
    public static int maxVal = 100001;

    public static int[] sieve = new int[maxVal];

    public static void sieveHelper() {
        sieve[1] = 1;
        for (int i = 2; i < maxVal; i++) {
            sieve[i] = i;
        }

        for (int i = 4; i < maxVal; i += 2) {
            sieve[i] = 2;
        }

        for (int i = 3; i * i < maxVal; i++) {
            if (sieve[i] == i) {
                for (int j = i * i; j < maxVal; j += i) {
                    if (sieve[j] == j) {
                        sieve[j] = i;
                    }
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static List<Integer> getFactors(int n) {
        List<Integer> list = new ArrayList<>();
        while (n != 1) {
            list.add(sieve[n]);
            n /= sieve[n];
        }

        return list;
    }

    public static int smallestValue(int n) {
        sieveHelper();
        if (n <= 5) {
            return n;
        }

        while (!isPrime(n)) {
            List<Integer> list = getFactors(n);
            int x = 0;
            for (int i = 0; i < list.size(); i++) {
                x += list.get(i);
            }

            n = x;
        }

        return n;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        System.out.println(smallestValue(n));
        scr.close();
    }
}
