package Assignment2;

import java.util.LinkedList;

public class MyQueue {

    LinkedList<NodeTrain> t;

    public MyQueue() {
        t = new LinkedList<NodeTrain>();
    }

    public boolean isEmpty() {
        return (t.isEmpty());
    }

    public void clear() {
        t.clear();
    }

    public void enqueue(NodeTrain p) {
        t.add(p);
    }

    public NodeTrain dequeue() {
        if (isEmpty()) {
            return (null);
        }
        return (t.removeFirst());
    }

    public NodeTrain front() {
        if (isEmpty()) {
            return (null);
        }
        return (t.getFirst());
    }
}
