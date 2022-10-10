import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class LUPrefix {
    Set<Integer> set;
    int max = 0;

    public LUPrefix(int n) {
        set = new HashSet<>();
    }

    public void upload(int video) {
        set.add(video);
        while (set.contains(max + 1)) {
            max++;
        }
    }

    public int longest() {
        return max;
    }
}

public class LongestUploadedPrefix {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = scr.next();
        }

        int[] video = new int[n];
        for (int i = 0; i < n; i++) {
            video[i] = scr.nextInt();
        }

        System.out.println(equalFrequency(s));

        scr.close();
    }
}
