public class PowerofNonA {
    public static int powerN(int a, int n) {
        if (n == 0)
            return 1;

        return a * powerN(a, n - 1);
    }

    public static void main(String[] args) {
        int a = 10;
        int n = 5;

        System.out.println(powerN(a, n));
    }
}
