package LAB2;
public class Queue {
    
    private static int front, last, capacity;   
    private static int queue[];   
    
    Queue(int c){   
        front = last = 0;   
        capacity = c;   
        queue = new int[capacity];   
    } 
    
    public void clear(){
        front = last = 0;
        capacity = 0;
    }
    
    // function to insert an element   
    // at the last of the queue   
    public void enqueue(int data){   
        // if queue is empty   
        if (isEmpty()) {   
            System.out.printf("\nQueue is empty\n");   
            return;   
        }   
        // check queue is full or not   
        if (capacity == last) {   
            System.out.printf("\nQueue is full\n");   
            return;   
        }   
        // insert element at the last   
        else {   
            queue[last] = data;   
            last++;   
        }   
        return;   
    }  
    
    // function to delete an element   
    // from the front of the queue   
    public int dequeue(){    
        // if queue is empty   
        if (isEmpty()) {   
            System.out.printf("\nQueue is empty\n");   
            return Integer.MIN_VALUE;   
        }   
        int item =queue[front];   
        front++;  
        capacity--;  
        return item;  
    } 
    
     // print queue elements   
    public void display()   {     
        int i;
        if (isEmpty()) {   
        System.out.printf("\nQueue is Empty\n");  
        return;  
        } 
        System.out.print("Traverse: ");
        // traverse front to last and print elements 
        for (i = front; i < last; i++) {   
            System.out.printf(" %d <-- ", queue[i]);   
        }   
        System.out.println();
        return;   
    }
    
    // print front of queue
    public void front(){
        if (front == last) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }
        System.out.printf("\nFront Element is: %d",queue[front]);
        System.out.println();
        return;
    }
    
    public boolean isEmpty(){
        if (front == -1 && last == -1) {
            return true;
        }else{
            return false;
        }
    }
    public void convertBinary(int num){  //roi
        int value = 0;
        while (num > 0) {            
            value = num % 2;
            enqueue(value);
            num = num / 2;
        }
        System.out.println("Decimal system to binary system: " + value);
    }



    
     
    
      
    
}
