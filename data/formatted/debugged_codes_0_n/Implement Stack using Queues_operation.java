```java
// Runtime: 0 ms (Top 100%) | Memory: 38.8 MB (Top 19.29%)
class MyStack {

    Queue<Integer> queue = null;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {

        Queue<Integer> tempQueue = new LinkedList<>();
        tempQueue.add(x);

        while (queue.size() > 0) {
            tempQueue.add(queue.remove());
        }

        queue = tempQueue;
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
```