public class Multiply2Number {
    public static int multiplyAtoB(int a, int b) {
        if (b == 1)
            return a;

        return a + multiplyAtoB(a, b - 1);
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        System.out.println(multiplyAtoB(a, b));
    }
}
