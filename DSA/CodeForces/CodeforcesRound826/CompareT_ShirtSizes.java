import java.util.Scanner;

public class CompareT_ShirtSizes {
    private static Character solve(String a, String b) {
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();

        int l1 = s1.length, l2 = s2.length;
        if (l1 == 0 && l2 == 0) {
            return '=';
        } else if (l1 == 0) {
            return '<';
        } else if (l2 == 0) {
            return '>';
        }

        char c1 = s1[l1 - 1];
        char c2 = s2[l2 - 1];

        if (c1 == 'S' && c2 == 'S') {
            if (l1 > l2) {
                return '<';
            } else if (l1 < l2) {
                return '>';
            } else {
                return '=';
            }
        } else if (c1 == 'L' && c2 == 'L') {
            if (l1 > l2) {
                return '>';
            } else if (l1 < l2) {
                return '<';
            } else {
                return '=';
            }
        } else if (c1 == 'S' && c2 == 'M') {
            return '<';
        } else if (c1 == 'S' && c2 == 'L') {
            return '>';
        } else if (c1 == 'M' && c2 == 'S') {
            return '>';
        } else if (c1 == 'M' && c2 == 'L') {
            return '<';
        } else if (c1 == 'L' && c2 == 'S') {
            return '>';
        } else if (c1 == 'L' && c2 == 'M') {
            return '>';
        }

        return '=';
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int t = scr.nextInt();

        while (t != 0) {
            String a = scr.next();
            String b = scr.next();

            System.out.println(solve(a, b));
            t--;
        }
        scr.close();
    }
}
