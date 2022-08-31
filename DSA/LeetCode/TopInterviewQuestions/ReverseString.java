import java.util.Scanner;

public class ReverseString {
    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();

        char[] s = new char[n];

        for (int i = 0; i < n; i++) {
            s[i] = scr.next().charAt(0);
        }
        reverseString(s);

        System.out.println(s);

        scr.close();
    }
}
