import java.util.Scanner;

public class ShiftingLettersII {
    public static String shiftingLetters(String s, int[][] shifts) {
        char[] ch = s.toCharArray();
        int[] count = new int[s.length() + 1];

        for (int[] shift : shifts) {
            int value = shift[2] == 1 ? 1 : -1;
            count[shift[0]] += value;
            count[shift[1] + 1] -= value;
        }

        int sum = 0;

        for (int i = 0; i < count.length - 1; i++) {
            sum += count[i];
            int newChar = ((ch[i] - 'a') + sum) % 26;

            if (newChar < 0)
                newChar += 26;

            ch[i] = (char) ('a' + newChar);
        }

        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String s = scr.next();
        int n = scr.nextInt();

        int[][] shifts = new int[n][3];

        for (int i = 0; i < n; i++) {
            shifts[i][0] = scr.nextInt();
            shifts[i][1] = scr.nextInt();
            shifts[i][2] = scr.nextInt();
        }

        System.out.println(shiftingLetters(s, shifts));

        scr.close();
    }
}
