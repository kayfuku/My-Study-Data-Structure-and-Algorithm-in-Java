// Queue.
// Author: アルゴリズムを学ぼう p.56 + kei.
// Date  : September 19, 2016


class Queue<T> {
    private LinkedList<T> values = new LinkedList<T>();

    public void enqueue(T v) {
        values.addFirst(v);
    }

    public T dequeue() {
        return values.pollLast();
    }

}










