import java.util.Scanner;

public class Maximum69Number {
    public static int maximum69Number(int num) {
        char[] arr = String.valueOf(num).toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '6') {
                arr[i] = '9';
                break;
            }
        }

        return Integer.valueOf(String.valueOf(arr));
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int num = scr.nextInt();
        System.out.println(maximum69Number(num));

        scr.close();
    }
}