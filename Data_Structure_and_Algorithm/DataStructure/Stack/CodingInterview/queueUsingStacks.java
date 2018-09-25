// Queue using Stacks. 
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








