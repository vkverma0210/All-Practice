import java.util.Scanner;

public class RectangleArea {
    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int rect1Area = (ax2 - ax1) * (ay2 - ay1);
        int rect2Area = (bx2 - bx1) * (by2 - by1);

        int overlapX = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overlapY = Math.min(ay2, by2) - Math.max(ay1, by1);
        int overlapArea = (overlapX > 0 && overlapY > 0) ? overlapX * overlapY : 0;

        return (rect1Area + rect2Area - overlapArea);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int ax1 = scr.nextInt();
        int ay1 = scr.nextInt();
        int ax2 = scr.nextInt();
        int ay2 = scr.nextInt();
        int bx1 = scr.nextInt();
        int by1 = scr.nextInt();
        int bx2 = scr.nextInt();
        int by2 = scr.nextInt();

        System.out.println(computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
        scr.close();
    }
}