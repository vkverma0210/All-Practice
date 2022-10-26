import java.util.Scanner;

class PythagoreanPair {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();

        while (t != 0) {
            int n = scr.nextInt();
            boolean flag = false;
            float wflo;
            int wdec;
            for (int i = 1; i * i <= n; i++) {
                int temp = n - (i * i);
                wdec = (int) Math.sqrt(temp);
                wflo = (float) Math.sqrt(temp);

                if (wdec == wflo) {
                    System.out.println(i + " " + wdec);
                    flag = true;
                    break;
                }
            }

            if (flag == false) {
                if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
                    System.out.println((int) Math.sqrt(n) + " " + 0);
                } else {
                    System.out.println(-1);
                }
            }
            t--;
        }

        scr.close();
    }
}
