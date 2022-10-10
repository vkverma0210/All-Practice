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

        LUPrefix lu = new LUPrefix(4);
        lu.upload(3);
        System.out.println(lu.longest());
        lu.upload(1);
        System.out.println(lu.longest());
        lu.upload(2);
        System.out.println(lu.longest());

        scr.close();
    }
}
