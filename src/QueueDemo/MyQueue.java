package QueueDemo;
public class MyQueue {
    private static int front, last, capacity;
    private static int queue[];

    public MyQueue() {
    }

    public MyQueue(int c) {
        front = last = -1;
        capacity = c;
        queue = new int[capacity];
    }
    
    public boolean isEmpty(){
        if (front == -1 && last == -1) {
            return true;
        }else{
            return false;
        }
    }
    
    //insert an element (VO) 
    public void enqueue(int data){
        if (isEmpty()) {
            System.out.printf("\nQueue is empty\n");
            return;
        }
        if (capacity == last) {
            System.out.printf("\nQueue is full\n"); 
            return;
        }else{
            queue[last] = data;
            last++;
        }
//        return;
    }
    
    //(RA)
    public int dequeue(){
        if (isEmpty()) {
            System.out.printf("\nQueue is empty\n");
            return Integer.MIN_VALUE;
        }
        int item = queue[front];
        front++;
        capacity--;
        return item;
    }
    
    public void display(){
        if (isEmpty()) {
            System.out.printf("\nQueue is empty\n");
            return;
        }
        for (int i = front; i < last; i++) {
            System.out.printf("%d<--",queue[i]);
        }
        return;
    }
    
    public void front(){
        if (front == last) {
            System.out.printf("\nQueue is empty\n");
            return;
        }
        System.out.printf("\nFront Element is: %d", queue[front]);
        return;
    }
    
    public static void main(String[] args) {
        MyQueue q = new MyQueue(4);
        q.display();
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.display();
        q.enqueue(60);
        q.display();
        q.dequeue();
        q.dequeue();
        System.out.printf("\nAfter two node deletion\n\n");
        q.display();
        q.front();
    }
    
}
