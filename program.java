import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    // Push operation: Add an element to the stack
    public void push(int data) {
        // Add the new element to queue1
        queue1.add(data);

        // Move all elements from queue2 to queue1
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }

        // Swap the names of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Pop operation: Remove and return the top element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        // Remove and return the front element from queue2
        return queue2.poll();
    }

    // Peek operation: Return the top element without removing it
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        // Return the front element from queue2 without removing it
        return queue2.peek();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue2.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.peek());

        System.out.println("Pop element: " + stack.pop());
        System.out.println("Pop element: " + stack.pop());

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
