// Queue using Stacks.
// Author: CtCI 3.4 p.236 + kei
// Date  : December 23, 2018

public class MyQueue<T> {
    LinkedList<T> stack1, stack2;

    public MyQueue() {
        stack1 = new LinkedList<T>();
        stack2 = new LinkedList<T>();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public void enqueue(T value) {
        stack1.push(value);
    }

    private void shiftStacks() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty) {
                stack2.push(stack1.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return stack2.peek();
    }

    public T dequeue() {
        shiftStacks();
        return stack2.pop();
    }

}


// Queue using Stacks. I don't think this is good. 
// Author: Google Handout Person B + kei
// Date  : February 5, 2017 

Stack in;
Stack out;

void enqueue(int value) {
    while (!out.isEmpty()) {
        in.push(out.pop());
    } 
    in.push(value);
}

int dequeue() {
    while (!in.isEmpty()) {
        out.push(in.pop());
    }
    return out.pop();
}








