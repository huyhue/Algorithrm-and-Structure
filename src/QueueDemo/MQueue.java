/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueDemo;

/**
 *
 * @author ASUS
 */
public class MQueue<T> {
    private int front, last, capacity;
    private T[] queue;

    public MQueue() {
    }

    public MQueue(int capacity) {
        front = last = 0;
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
    }

    public void enqueue(T data) {
        if (isEmpty()) {
            System.out.printf("\nQueue is empty\n");
            return;
        }
        if (last == capacity) {
            System.out.println("Can not add because queue is full");
        } else {
            System.out.println("Add success");
            queue[last] = data;
            last++;
        }
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public void clear() {
        front = -1;
        last = -1;
        capacity = 0;
    }

    public T dequeue() {
        T item = null;
        if (isEmpty()) {
            System.out.println("Quese is empty");
        } else {
            item = queue[front];
            front++;
            capacity--;
        }
        return item;
    }

    public void display() {
        System.out.println("My Queue data is");
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            for (int i = front; i < last; i++) {
                System.out.print(queue[i] + " <-- ");
            }
            System.out.println("");
        }
    }

    public void front() {
        if (front == last) {
            System.out.println("Queue is Empty");
        }
        System.out.println("First element is " + queue[front]);
    }
    public static void main(String[] args) {
        MQueue myQueue = new MQueue(4);
        myQueue.enqueue("Huy");
        myQueue.enqueue("Vu");
        myQueue.enqueue("Thanh");
        myQueue.enqueue("Quang");
        myQueue.enqueue("Tuan");
        myQueue.display();
        System.out.print("Dequeue: ");
        System.out.println(myQueue.dequeue());
    }
}
