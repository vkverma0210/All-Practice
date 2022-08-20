import java.util.Scanner;

public class TimeNeededToRearrangeABinaryString {
    public static int secondsToRemoveOccurrences_DP(String s) {
        int zeros = 0, seconds = 0;

        for (int i = 0; i < s.length(); i++) {
            zeros += s.charAt(i) == '0' ? 1 : 0;

            if (s.charAt(i) == '1' && zeros > 0)
                seconds = Math.max(seconds + 1, zeros);
        }

        return seconds;
    }

    public static int secondsToRemoveOccurrences_Brute(String s) {
        char ch[] = s.toCharArray();
        int k = 0;
        while (s.contains("01")) {
            for (int i = 0; i < ch.length - 1; i++) {
                if (ch[i] == '0' && ch[i + 1] == '1') {
                    char temp = ch[i];
                    ch[i] = ch[i + 1];
                    ch[i + 1] = temp;
                    i++;
                }
            }

            s = String.valueOf(ch);
            ch = s.toCharArray();
            k++;
        }

        return k;
    }

    public static int secondsToRemoveOccurrences_String(String s) {
        int seconds = 0;
        while (s.indexOf("01") >= 0) {

            s = s.replace("01", "10");
            seconds++;
        }

        return seconds;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        String str = scr.next();

        System.out.println(secondsToRemoveOccurrences_DP(str));
        System.out.println(secondsToRemoveOccurrences_Brute(str));
        System.out.println(secondsToRemoveOccurrences_String(str));

        scr.close();
    }
}
