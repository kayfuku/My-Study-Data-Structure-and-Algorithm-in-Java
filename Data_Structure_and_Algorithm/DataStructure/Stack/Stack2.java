// Stack.
// Author: アルゴリズムを学ぼう p.55 + kei.
// Date  : September 19, 2016


class Stack<T> {
    private LinkedList<T> values = new LinkedList<T>();

    public void push(T v) {
        values.add(v);
    }

    public T pop() {
        return values.pollLast();
    }
}


