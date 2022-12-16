import java.util.Queue;
import java.util.Stack;

class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }

        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
