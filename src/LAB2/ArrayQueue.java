package LAB2;

public class ArrayQueue {

    // Driver code
    public static void main(String[] args) {
        // Create a queue of capacity 4
        Queue q = new Queue(4);
        // print Queue elements
        q.display();
        // inserting elements in the queue
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        // print Queue elements
        q.display();
        
        // insert element in the queue
        q.enqueue(60);
        // print Queue elements
        q.display();
        
        q.dequeue();
        q.dequeue();
        System.out.printf("\n\nafter two node deletion\n\n");
        // print Queue elements
        q.display();
        
        // print front of the queue
        q.front();
        q.display();
        
        q.clear();
        q.display();
    }
}
