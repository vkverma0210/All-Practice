import java.util.Scanner;
import java.util.Stack;

class StockSpanner {
    Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (st.size() > 0 && price >= st.peek()[0]) {
            span += st.pop()[1];
        }

        st.push(new int[] { price, span });

        return span;
    }
}

public class OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
}