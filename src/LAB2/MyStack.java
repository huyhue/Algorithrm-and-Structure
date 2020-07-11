package LAB2;
import java.util.EmptyStackException;

public class MyStack {
    private int top;
    private int[] storage;

    public MyStack() {
        top = -1;
    }
    
    public void clear() {
        top=-1;//sai
    }

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Stack's capacity must be positive");
        }
        storage = new int[capacity];
        top = -1;
    }
    
    public void push(int value){
        if (top == storage.length) {
            throw new StackOverflowError("Stack's underlying storage is overflow");
        }
        top++;
        storage[top] = value;
    }
    public int peek(){
        if (top == -1) {
            throw new EmptyStackException();
        }
        return storage[top];
    }
    public int pop(){
        if (top == -1) {
            throw new EmptyStackException();
        }
        int tmp = storage[top];
        top--;
        return tmp;
    }
    public void pop1(int value){
        if (top == -1) {
            throw new EmptyStackException();
        }
        top--;
    }
    public void popAll(){
        while(!isEmpty()){
            pop();
        }
    }
    public boolean isEmpty(){
        if (top == -1) {
            return true;
        }else{
            return false;
        }      
    }
    public void display(){
        System.out.println("Array List = ");
        for (int i = 0; i < storage.length; i++) {
            System.out.print(" " + storage[i]);    
        }
         System.out.println();
    }
    
    public void displayStack(){
         System.out.print("StackList = "); 
         while(!isEmpty()){
               System.out.print("  " + pop()); 
         } 
         System.out.println();
    }
    
    public void traverse(){ //roi
        for (int i = top; i >= 0; i--) {
            System.out.print("\t" + storage[i]);
        }
        System.out.println();
    }
    
    public void convertBinary(int num){  //roi
        int value = 0;
        while (num > 0) {            
            value = num % 2;
            push(value);
            num = num / 2;
        }
        System.out.println("Decimal system to binary system: " + value);
    }
}
